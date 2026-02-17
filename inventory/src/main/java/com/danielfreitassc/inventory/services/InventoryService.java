package com.danielfreitassc.inventory.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.danielfreitassc.inventory.dtos.InventoryRequestDto;
import com.danielfreitassc.inventory.dtos.InventoryResponseDto;
import com.danielfreitassc.inventory.exceptions.InventoryNotFoundException;
import com.danielfreitassc.inventory.exceptions.ProductNotFoundException;
import com.danielfreitassc.inventory.mappers.InventoryMapper;
import com.danielfreitassc.inventory.models.InventoryEntity;
import com.danielfreitassc.inventory.repositories.InventoryRepository;
import com.danielfreitassc.inventory.repositories.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;
    private final ProductRepository productRepository;

    @Transactional
    public InventoryResponseDto create(InventoryRequestDto inventoryRequestDto) {
        findProductOrThrow(inventoryRequestDto.productId());
        InventoryEntity inventoryEntity = inventoryMapper.dtoToEntity(inventoryRequestDto);
        inventoryRepository.save(inventoryEntity);
        return inventoryMapper.entityToDto(inventoryEntity);
    }

    public Page<InventoryResponseDto> getInventory(Pageable pageable) {
        return inventoryRepository.findAll(pageable).map(inventoryMapper::entityToDto);
    }

    public InventoryResponseDto getInventoryById(UUID id) {
        return inventoryMapper.entityToDto(findInventoryOrThrow(id));
    }

    @Transactional
    public InventoryResponseDto updateById(UUID id, InventoryRequestDto inventoryRequestDto) {
        findProductOrThrow(inventoryRequestDto.productId());
        InventoryEntity inventoryEntity = findInventoryOrThrow(id);

        inventoryMapper.toUpdate(inventoryRequestDto, inventoryEntity);

        return inventoryMapper.entityToDto(inventoryEntity);
    }

    public void deleteById(UUID id) {
        inventoryRepository.delete(findInventoryOrThrow(id));
    }

    private void findProductOrThrow(UUID id) {
        productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    private InventoryEntity findInventoryOrThrow(UUID id) {
        return inventoryRepository.findById(id).orElseThrow(InventoryNotFoundException::new);
    }
}
