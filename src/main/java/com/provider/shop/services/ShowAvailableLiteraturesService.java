package com.provider.shop.services;

import com.provider.shop.models.persistence.entities.LibraryItem;
import com.provider.shop.models.persistence.repositories.LibraryItemJpaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowAvailableLiteraturesService {

    private final LibraryItemJpaRepository libraryItemJpaRepository;

    public List<LibraryItem> getAllLiteratures() {
        return libraryItemJpaRepository.findAll();
    }

}
