package com.provider.shop.services;

import com.provider.shop.domain.LoanEntity;
import com.provider.shop.models.dtos.LiteratureDTO;
import com.provider.shop.models.dtos.LoanDto;
import com.provider.shop.models.mapper.LoanMapper;
import com.provider.shop.models.persistence.entities.LibraryItem;
import com.provider.shop.models.persistence.entities.LibraryItemLoan;
import com.provider.shop.models.persistence.entities.Loan;
import com.provider.shop.models.persistence.entities.User;
import com.provider.shop.models.persistence.repositories.LibraryItemJpaRepository;
import com.provider.shop.models.persistence.repositories.LibraryLoanItemJpaRepository;
import com.provider.shop.models.persistence.repositories.LoanRequestJpaRepository;
import com.provider.shop.models.persistence.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class LoanLibraryService {

    @Value("${spring.mail.username}")
    private String fromEmailId;
    private LoanRequestJpaRepository repository;
    private LoanMapper mapper;
    private LibraryItemJpaRepository libraryRepository;
    private LibraryLoanItemJpaRepository libraryLoanRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private ShowAvailableLiteraturesService availableLiteraturesService;
    @Autowired
    private LibraryItemJpaRepository libraryItemJpaRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;



    public LoanLibraryService(LoanRequestJpaRepository repository, LoanMapper mapper, LibraryItemJpaRepository libraryRepository, LibraryLoanItemJpaRepository libraryLoanRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.libraryRepository = libraryRepository;
        this.libraryLoanRepository = libraryLoanRepository;
    }

    @Transactional
    public Loan requestLoan(LoanDto body) {
        List<UUID> libraryItemIds = body.libraryItemIds;
        List<LibraryItem> libraryItems = libraryRepository.findAllById(libraryItemIds);

        LoanEntity loanEntity = new LoanEntity(body.readerId, body.loanDays);
        Loan userLoan = mapper.domainToEntity(loanEntity);
        userLoan = repository.saveAndFlush(userLoan);
        List<LibraryItemLoan> libraryItemLoans = mapper.mapLibraryItemsToLoans(libraryItems, userLoan);
        userLoan.setLibraryItemLoans(libraryItemLoans);
        libraryLoanRepository.saveAll(libraryItemLoans);

        User user = userJpaRepository.findByuserId(UUID.fromString(body.readerId));


        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("pinguinerasas@gmail.com");
        msg.setTo(user.getEmail());
        msg.setSubject("Detalles del préstamo");
        msg.setText(generateText(libraryItems, user.getUsername()));
        javaMailSender.send(msg);

        return userLoan;
    }

    private String generateText(List<LibraryItem> libraryItems, String username) {

        StringBuilder sb = new StringBuilder();
        sb.append("Estimado " + username).append("\n\n");
        sb.append("Se ha registrado un préstamo de libros a su nombre. Detalles del préstamo:\n");
        sb.append("Fecha de préstamo: ").append(LocalDate.now()).append("\n");
        sb.append("Libros prestados:\n");

        for(LibraryItem book : libraryItems) {
            sb.append("- ").append(book.getTitle()).append("\n");
        }
        sb.append("\nGracias por utilizar nuestro servicio de préstamo de libros.\n");
        sb.append("Atentamente,\nLa Pinguinera");
        return sb.toString();

    }
}
