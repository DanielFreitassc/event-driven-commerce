package com.danielfreitassc.inventory.exceptions;

public class InventoryNotFoundException extends RuntimeException {
    public InventoryNotFoundException() {
        super("Inventory not found");
    }
}
