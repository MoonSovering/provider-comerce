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
@Table(name = "NovelLibraryItem")
public class NovelLibraryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID novelLibraryItem;

    private String genre;
    private Integer suggestedAge;

    @OneToOne
    @JoinColumn(name = "novelLibraryItemId")
    private LibraryItem libraryItem;

}
