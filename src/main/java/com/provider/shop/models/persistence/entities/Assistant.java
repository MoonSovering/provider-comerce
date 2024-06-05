package com.provider.shop.models.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "Assistant")
public class Assistant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID assistantId;

    @OneToOne
    @JoinColumn(name = "assistantId")
    private User user;
}
