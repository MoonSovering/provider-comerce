package com.provider.shop.models.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "BookSupplierItem")
@Setter
@Getter
public class BookSupplierItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookSupplierItemId;

    private String knowledgeArea;
    private Integer pages;

    @OneToOne
    //@JoinColumn(name = "bookSupplierItemId")
    private SupplierItem supplierItem;
}
