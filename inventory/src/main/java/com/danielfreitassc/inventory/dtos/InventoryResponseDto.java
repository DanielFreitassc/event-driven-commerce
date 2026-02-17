package com.danielfreitassc.inventory.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record InventoryResponseDto(
    UUID id,
    UUID productId,
    Long availableQuantity,
    LocalDateTime updatedAt
) {
    
}
