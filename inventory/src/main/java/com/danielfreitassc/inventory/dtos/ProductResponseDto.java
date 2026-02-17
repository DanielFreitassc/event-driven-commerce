package com.danielfreitassc.inventory.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductResponseDto(
    UUID id,
    String sku, 
    String name,
    String description,
    BigDecimal price,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    
}
