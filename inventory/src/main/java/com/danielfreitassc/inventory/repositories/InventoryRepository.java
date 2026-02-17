package com.danielfreitassc.inventory.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielfreitassc.inventory.models.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, UUID> {
    
}
