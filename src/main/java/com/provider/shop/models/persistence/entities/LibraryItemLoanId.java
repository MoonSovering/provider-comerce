package com.provider.shop.models.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryItemLoanId implements Serializable {
    @Column(name = "library_item_library_item_id")
    private UUID libraryItemId;

    @Column(name = "loan_loan_id")
    private UUID loanIdLoanId;
}