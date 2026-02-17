package com.danielfreitassc.inventory.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductRequestDto(
    @NotBlank(message = "a product needs a name")
    String name,
    @NotBlank(message = "a product needs a description")
    String description,
    @Min(value = 0,message = "a product needs to have a price higher than zero")
    BigDecimal price
) {
    
}
