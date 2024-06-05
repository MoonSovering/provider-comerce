package com.provider.shop.models.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "\"Supplier\"")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID supplierId;

    @OneToOne
    @JoinColumn(name = "supplierId")
    private User user;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private List<SupplierItem> supplierItems = new ArrayList<>();
}
