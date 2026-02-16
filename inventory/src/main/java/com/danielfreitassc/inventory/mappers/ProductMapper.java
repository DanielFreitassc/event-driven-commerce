package com.danielfreitassc.inventory.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.danielfreitassc.inventory.dtos.ProductRequestDto;
import com.danielfreitassc.inventory.dtos.ProductResponseDto;
import com.danielfreitassc.inventory.models.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponseDto entityToDto(ProductEntity productEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProductEntity dtoToEntity(ProductRequestDto productRequestDto);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(ProductRequestDto productRequestDto, @MappingTarget ProductEntity productEntity);
}
