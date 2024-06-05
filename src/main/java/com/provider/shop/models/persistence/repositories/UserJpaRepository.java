package com.provider.shop.models.persistence.repositories;

import com.provider.shop.models.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<User, UUID> {
    User findByUserName(String username);
}