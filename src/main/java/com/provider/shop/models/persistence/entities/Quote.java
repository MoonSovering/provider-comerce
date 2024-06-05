package com.provider.shop.models.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "\"Quote\"")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID quoteId;

    private LocalDate createdAt = LocalDate.now();
    private String type;
    private Double totalPrice;
    private Double retailOverPrice;
    private Double seniorityDiscount;
    private Double typeDiscount;

    @OneToMany(mappedBy = "quote", fetch = FetchType.EAGER)
    private List<QuoteSupplierItem> quoteSupplierItems;

}
