package com.provider.shop.models.persistence.entities;

import com.provider.shop.shared.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Table(name = "\"User\"")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String username;
    private String refreshToken;
    private String email;
    private String password;
    private LocalDate registeredAt;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String salt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Assistant assistant;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Admin admin;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Reader reader;

}
