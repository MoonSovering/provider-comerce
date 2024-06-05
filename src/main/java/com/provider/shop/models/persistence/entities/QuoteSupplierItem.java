package com.provider.shop.models.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Quote_SupplierItem")
public class QuoteSupplierItem {

    @EmbeddedId
    private QuoteSupplierItemId quoteSupplierItemId;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Quote_quoteId", insertable = false, updatable = false)
    private Quote quote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SupplierItem_supplierItemId", insertable = false, updatable = false)
    private SupplierItem supplierItem;

}
