package com.provider.shop.services;

import com.provider.shop.models.dtos.LiteratureDTO;
import com.provider.shop.models.factory.Mapper;
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
    private final Mapper mapper;

    public List<LiteratureDTO> getAllLiteratures() {
        return libraryItemJpaRepository.findAll()
                .stream()
                .map(libraryItem -> {
                    if(libraryItem.getBookLibraryItem() != null) {
                        return mapper.toLiteratureDTO(libraryItem,"Book");
                    }
                    return mapper.toLiteratureDTO(libraryItem,"Novel");
                }).toList();
    }

}
