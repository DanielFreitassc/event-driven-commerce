package com.danielfreitassc.inventory.dtos;

public record FieldErrorResponse(
    String field,
    String message
) {
    
}
