package com.provider.shop.models.persistence.repositories;

import com.provider.shop.models.persistence.entities.LibraryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LibraryItemJpaRepository extends JpaRepository<LibraryItem, UUID> {
    LibraryItem findBylibraryItemId(UUID id);
}
