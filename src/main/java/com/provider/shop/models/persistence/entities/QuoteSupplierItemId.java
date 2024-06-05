package com.provider.shop.models.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Embeddable
public class QuoteSupplierItemId implements Serializable {
    @Column(name = "Quote_quoteId")
    private UUID quoteId;

    @Column(name = "SupplierItem_supplierItemId")
    private UUID supplierItemId;
}
