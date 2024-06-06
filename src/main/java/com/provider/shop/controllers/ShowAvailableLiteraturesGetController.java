package com.provider.shop.controllers;

import com.provider.shop.models.persistence.entities.LibraryItem;
import com.provider.shop.services.ShowAvailableLiteraturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ShowAvailableLiteraturesGetController {

    private final ShowAvailableLiteraturesService literaturesService;
    @GetMapping("/literatures")
    public List<LibraryItem> getAllLiteratures() {
        return literaturesService.getAllLiteratures();
    }

}
