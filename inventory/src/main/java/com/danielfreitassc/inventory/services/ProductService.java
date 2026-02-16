package com.danielfreitassc.inventory.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.danielfreitassc.inventory.dtos.ProductRequestDto;
import com.danielfreitassc.inventory.dtos.ProductResponseDto;
import com.danielfreitassc.inventory.exceptions.ProductNotFoundException;
import com.danielfreitassc.inventory.mappers.ProductMapper;
import com.danielfreitassc.inventory.models.ProductEntity;
import com.danielfreitassc.inventory.repositories.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final SkuGeneratorService skuGeneratorService;

    @Transactional
    public ProductResponseDto create(ProductRequestDto productRequestDto) {
        ProductEntity productEntity = productMapper.dtoToEntity(productRequestDto);
        String sku = skuGeneratorService.generate();
        productEntity.setSku(sku);
        productRepository.save(productEntity);

        return productMapper.entityToDto(productEntity);
    }

    public Page<ProductResponseDto> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(productMapper::entityToDto);
    }

    public ProductResponseDto getById(UUID id) {
        return productMapper.entityToDto(findProductOrThrow(id));
    }

    public void deleteById(UUID id) {
        ProductEntity productEntity = findProductOrThrow(id);
        productRepository.delete(productEntity);
    }

    @Transactional
    public ProductResponseDto updateById(UUID id, ProductRequestDto productRequestDto) {
        ProductEntity productEntity = findProductOrThrow(id);

        productMapper.updateEntity(productRequestDto, productEntity);

        productRepository.save(productEntity);

        return productMapper.entityToDto(productEntity);
    }

    private ProductEntity findProductOrThrow(UUID id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }
}
