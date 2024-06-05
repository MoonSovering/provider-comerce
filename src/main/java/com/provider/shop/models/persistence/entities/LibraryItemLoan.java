package com.provider.shop.models.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "\"LibraryItem_Loan\"")
public class LibraryItemLoan {


    @EmbeddedId
    private LibraryItemLoanId libraryItemLoanId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "Loan_loanId",insertable = false, updatable = false)
    private Loan loan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "LibraryItem_libraryItemId", insertable = false, updatable = false)
    private LibraryItem libraryItem;

}
