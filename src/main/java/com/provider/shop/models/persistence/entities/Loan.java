package com.provider.shop.models.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.provider.shop.shared.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID loanId;

    private UUID readerId;
    private LocalDate createdAt = LocalDate.now();
    private LocalDate updatedAt = LocalDate.now();

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private String observation;
    private LocalDate pickUpDate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "readerId", insertable = false, updatable = false)
    private Reader reader;

    @JsonManagedReference
    @OneToMany(mappedBy = "loan")
    private List<LibraryItemLoan> libraryItemLoans = new ArrayList<>();


}
