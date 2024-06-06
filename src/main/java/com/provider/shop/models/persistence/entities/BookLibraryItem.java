package com.provider.shop.models.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "\"BookLibraryItem\"")
public class BookLibraryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookLibraryItemId;

    private Integer pages;
    private String knowledgeArea;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookLibraryItemId")
    private LibraryItem libraryItem;
}
