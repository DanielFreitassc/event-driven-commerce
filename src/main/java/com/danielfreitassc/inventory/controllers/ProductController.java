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

import com.danielfreitassc.inventory.dtos.ProductRequestDto;
import com.danielfreitassc.inventory.dtos.ProductResponseDto;
import com.danielfreitassc.inventory.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto create(@RequestBody @Valid ProductRequestDto productRequestDto) {
        return productService.create(productRequestDto);
    }

    @GetMapping
    public Page<ProductResponseDto> getProducts(Pageable pageable) {
        return productService.getProducts(pageable);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable UUID id) {
        return productService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDto updateById(@PathVariable UUID id,@RequestBody @Valid ProductRequestDto productRequestDto) {
        return productService.updateById(id, productRequestDto);
    }
}
