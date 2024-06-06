package com.provider.shop.models.persistence.repositories;

import com.provider.shop.models.persistence.entities.LibraryItemLoan;
import com.provider.shop.models.persistence.entities.LibraryItemLoanId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LibraryLoanItemJpaRepository extends JpaRepository<LibraryItemLoan, LibraryItemLoanId> {
}
