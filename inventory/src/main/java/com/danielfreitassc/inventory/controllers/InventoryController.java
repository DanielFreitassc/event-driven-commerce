package com.danielfreitassc.inventory.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danielfreitassc.inventory.dtos.InventoryRequestDto;
import com.danielfreitassc.inventory.dtos.InventoryResponseDto;
import com.danielfreitassc.inventory.services.InventoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/inventories")
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryResponseDto create(@RequestBody @Valid InventoryRequestDto inventoryRequestDto) {
        return inventoryService.create(inventoryRequestDto);
    }

    @GetMapping
    public Page<InventoryResponseDto> getInventory(Pageable pageable) {
        return inventoryService.getInventory(pageable);
    }

    @GetMapping("/{id}")
    public InventoryResponseDto getInventoryById(@PathVariable UUID id) {
        return inventoryService.getInventoryById(id);
    }

    @PutMapping("/{id}")
    public InventoryResponseDto updateById(@PathVariable UUID id,@RequestBody @Valid InventoryRequestDto inventoryRequestDto) {
        return inventoryService.updateById(id, inventoryRequestDto);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        inventoryService.deleteById(id);
    }
}
