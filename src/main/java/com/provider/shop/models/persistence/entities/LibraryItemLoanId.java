package com.provider.shop.models.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
public class LibraryItemLoanId implements Serializable {
    @Column(name = "\"LibraryItem_libraryItemId\"")
    private UUID libraryItemId;

    @Column(name = "\"Loan_loanId\"")
    private UUID loanId;
}
