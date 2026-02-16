package com.danielfreitassc.inventory.dtos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public record ProductResponseDto(
    UUID id,
    String sku, 
    String name,
    String description,
    BigDecimal price,
    Timestamp createdAt,
    Timestamp updatedAt
) {
    
}
