package com.provider.shop.models.factory;

import com.provider.shop.models.dtos.LiteratureDTO;
import com.provider.shop.models.persistence.entities.LibraryItem;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public LiteratureDTO toLiteratureDTO(LibraryItem libraryItem, String type) {
        LiteratureDTO literatureDTO = new LiteratureDTO();
        literatureDTO.setLibraryItemId(libraryItem.getLibraryItemId().toString());
        literatureDTO.setTitle(libraryItem.getTitle());
        literatureDTO.setAuthor(libraryItem.getAuthor());
        literatureDTO.setStock(libraryItem.getStock());
        literatureDTO.setBorrowedQuantity(libraryItem.getBorrowedQuantity());
        literatureDTO.setType(type);
        return literatureDTO;
    }

    public LibraryItem toLibraryItem(LiteratureDTO literatureDTO) {
        LibraryItem libraryItem = new LibraryItem();
        libraryItem.setTitle(literatureDTO.getTitle());
        libraryItem.setAuthor(literatureDTO.getAuthor());
        libraryItem.setStock(literatureDTO.getStock());
        libraryItem.setBorrowedQuantity(literatureDTO.getBorrowedQuantity());
        return libraryItem;
    }

}
