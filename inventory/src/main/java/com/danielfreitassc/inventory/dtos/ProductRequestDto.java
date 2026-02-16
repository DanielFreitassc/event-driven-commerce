package com.danielfreitassc.inventory.dtos;

import java.math.BigDecimal;

public record ProductRequestDto(
    String name,
    String description,
    BigDecimal price
) {
    
}
