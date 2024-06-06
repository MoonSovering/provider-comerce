package com.provider.shop.models.persistence.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "\"Reader\"")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID readerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "reader", fetch = FetchType.EAGER)
    private List<Loan> loans = new ArrayList<>();
}
