package com.provider.shop.models.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SupplierItem")
public class SupplierItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID supplierItemId;

    private UUID supplierId;
    private String title;
    private String author;
    private Double basePrice;
    private Double sellPrice;
    private Integer stock;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "supplierId", insertable = false, updatable = false)
    private Supplier supplier;

    @OneToOne(mappedBy = "supplierItem")
    private BookSupplierItem bookSupplierItem;

    @OneToOne(mappedBy = "supplierItem")
    private NovelSupplierItem novelSupplierItem;

    @OneToMany(mappedBy = "supplierItem", fetch = FetchType.EAGER)
    private List<QuoteSupplierItem> quoteSupplierItems;
}
