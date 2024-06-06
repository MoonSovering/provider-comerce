package com.provider.shop.models.mapper;

import com.provider.shop.domain.LoanEntity;
import com.provider.shop.models.persistence.entities.LibraryItem;
import com.provider.shop.models.persistence.entities.LibraryItemLoan;
import com.provider.shop.models.persistence.entities.LibraryItemLoanId;
import com.provider.shop.models.persistence.entities.Loan;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class LoanMapper {
    public Loan domainToEntity(LoanEntity loanEntity) {
        Loan loan = new Loan();
        loan.setReaderId(UUID.fromString(loanEntity.getReaderId()));
        loan.setStatus(loanEntity.getStatus());
        loan.setObservation(loanEntity.getObservation());
        loan.setLoanDays(loanEntity.getLoanDays());
        loan.setCreatedAt(LocalDate.now());
        loan.setUpdatedAt(LocalDate.now());
        return loan;
    }

    public LoanEntity entityToDomain(Loan loan) {
        LoanEntity loanEntity = new LoanEntity(loan.getReaderId().toString(), loan.getLoanDays());
        loanEntity.setStatus(loan.getStatus());
        loanEntity.setObservation(loan.getObservation());
        return loanEntity;
    }

    public List<LibraryItemLoan> mapLibraryItemsToLoans(List<LibraryItem> libraryItems, Loan loan) {
        return libraryItems.stream()
                .map(item -> {
                    LibraryItemLoan libraryItemLoan = new LibraryItemLoan();
                    LibraryItemLoanId libraryItemLoanId = new LibraryItemLoanId(item.getLibraryItemId(), loan.getLoanId());
                    libraryItemLoan.setLibraryItemLoanPK(libraryItemLoanId);
                    libraryItemLoan.setLibraryItem(item);
                    return libraryItemLoan;
                })
                .collect(Collectors.toList());
    }
}
