package com.danielfreitassc.inventory.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record InventoryRequestDto(
    @NotNull(message = "It is necessary to indicate a product")
    UUID productId,
    @Min(value = 0,message = "value must be greater than zero")
    Long availableQuantity
) {
    
}
