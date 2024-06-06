package com.provider.shop.controllers;

import com.provider.shop.models.dtos.LiteratureDTO;
import com.provider.shop.models.persistence.entities.LibraryItem;
import com.provider.shop.services.ShowAvailableLiteraturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ShowAvailableLiteraturesGetController {

    private final ShowAvailableLiteraturesService literaturesService;

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmailId;
    @GetMapping("/literatures")
    public List<LiteratureDTO> getAllLiteratures() {
        return literaturesService.getAllLiteratures();
    }

    @PostMapping("/loan")
    public String sendByEmail(@RequestBody BodyEmail bodyEmail) {
        Object prestamo = new Object();
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("pinguinerasas@gmail.com");
        msg.setTo(bodyEmail.getEmail());
        msg.setSubject("Detalles del préstamo");
        msg.setText(generateText(prestamo, bodyEmail.getEmail()));
        javaMailSender.send(msg);
        return "It's working!!";
    }

    private String generateText(Object prestamo, String email) {
        List<LiteratureDTO> books = literaturesService.getAllLiteratures();
        StringBuilder sb = new StringBuilder();
        sb.append("Estimado " + email).append("\n\n");
        sb.append("Se ha registrado un préstamo de libros a su nombre. Detalles del préstamo:\n");
        sb.append("Fecha de préstamo: ").append("10/08/2024").append("\n");
        sb.append("Fecha de devolución: ").append("11/07/2024").append("\n");
        sb.append("Libros prestados:\n");

        for(LiteratureDTO book : books) {
            sb.append("- ").append(book.getTitle()).append("\n");
        }
        sb.append("\nGracias por utilizar nuestro servicio de préstamo de libros.\n");
        sb.append("Atentamente,\nLa Pinguinera");
        return sb.toString();

    }


}
