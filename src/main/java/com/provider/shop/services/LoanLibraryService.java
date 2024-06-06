package com.provider.shop.services;

import com.provider.shop.domain.LoanEntity;
import com.provider.shop.models.dtos.LoanDto;
import com.provider.shop.models.mapper.LoanMapper;
import com.provider.shop.models.persistence.entities.LibraryItem;
import com.provider.shop.models.persistence.entities.LibraryItemLoan;
import com.provider.shop.models.persistence.entities.Loan;
import com.provider.shop.models.persistence.repositories.LibraryItemJpaRepository;
import com.provider.shop.models.persistence.repositories.LibraryLoanItemJpaRepository;
import com.provider.shop.models.persistence.repositories.LoanRequestJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class LoanLibraryService {

    private LoanRequestJpaRepository repository;
    private LoanMapper mapper;
    private LibraryItemJpaRepository libraryRepository;
    private LibraryLoanItemJpaRepository libraryLoanRepository;

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
        return userLoan;
    }
}
