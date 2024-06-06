package com.provider.shop.models.persistence.repositories;

import com.provider.shop.models.persistence.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanRequestJpaRepository extends JpaRepository<Loan, UUID> {
}
