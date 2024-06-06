package com.provider.shop.models.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "\"NovelLibraryItem\"")
public class NovelLibraryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID novelLibraryItemId;

    private String genre;
    private Integer suggestedAge;

    @JsonBackReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "novelLibraryItemId")
    private LibraryItem libraryItem;

}
