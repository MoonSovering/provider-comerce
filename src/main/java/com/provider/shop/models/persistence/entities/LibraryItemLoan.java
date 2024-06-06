package com.provider.shop.models.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"LibraryItem_Loan\"")
public class LibraryItemLoan {

    @EmbeddedId
    private LibraryItemLoanId libraryItemLoanPK;

    @ManyToOne
    @MapsId("libraryItemId")
    @JoinColumn(name = "library_item_library_item_id")
    @JsonBackReference
    private LibraryItem libraryItem;
}