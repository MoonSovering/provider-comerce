package com.provider.shop.models.persistence.repositories;

import com.provider.shop.models.persistence.entities.LibraryItem;


import com.provider.shop.models.persistence.entities.LibraryItemLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import java.util.UUID;

public interface LibraryItemJpaRepository extends JpaRepository<LibraryItem, UUID> {
}
