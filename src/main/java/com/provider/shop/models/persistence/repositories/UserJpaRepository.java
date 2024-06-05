package com.provider.shop.models.persistence.repositories;

import com.provider.shop.models.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<User, UUID> {
    User findByusername(String username);
}