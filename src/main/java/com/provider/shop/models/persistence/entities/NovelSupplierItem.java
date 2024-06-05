package com.provider.shop.models.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "\"NovelSupplierItem\"")
@Setter
@Getter
public class NovelSupplierItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID novelSupplierItemId;
    private Integer suggestedAge;
    private String genre;

    @OneToOne
//    @JoinColumn(name = "novelSupplierItemId")
    private SupplierItem supplierItem;
}
