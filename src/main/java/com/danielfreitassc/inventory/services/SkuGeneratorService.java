package com.danielfreitassc.inventory.services;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class SkuGeneratorService {
    
    public String generate() {
        return "GS-" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }
}
