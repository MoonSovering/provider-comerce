package com.provider.shop.models.persistence.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "\"LibraryItem\"")
public class LibraryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID libraryItemId;

    private String title;
    private String author;
    private Integer stock;
    private Integer borrowedQuantity;

    @JsonManagedReference
    @OneToMany(mappedBy = "libraryItem")
    private List<LibraryItemLoan> libraryItemLoans = new ArrayList<>();

    @OneToOne(mappedBy = "libraryItem")
    private BookLibraryItem bookLibraryItem;

    @OneToOne(mappedBy = "libraryItem")
    private NovelLibraryItem novelLibraryItem;



}
