package com.danielfreitassc.inventory.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielfreitassc.inventory.models.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    
}
