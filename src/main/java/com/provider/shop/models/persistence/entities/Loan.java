package com.provider.shop.models.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.provider.shop.shared.enums.LibraryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "loan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "loan_id")
    private UUID loanId;

    @Column(name = "reader_id")
    private UUID readerId;

    @Enumerated(value = EnumType.STRING)
    private LibraryStatus status;

    @Column(name = "observation")
    private String observation;

    @CreatedDate
    @Column(name = "created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;

    @Column(name = "pick_up_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @Column(name = "loan_days")
    private Integer loanDays;

    @ManyToOne
    @JoinColumn(name = "reader_id", insertable = false, updatable = false)
    @JsonManagedReference
    private Reader reader;

    @OneToMany(mappedBy = "libraryItemLoanPK.loanIdLoanId")
    private List<LibraryItemLoan> libraryItemLoans;
}
