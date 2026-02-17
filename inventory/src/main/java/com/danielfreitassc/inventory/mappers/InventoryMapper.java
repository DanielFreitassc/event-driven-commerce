package com.danielfreitassc.inventory.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.danielfreitassc.inventory.dtos.InventoryRequestDto;
import com.danielfreitassc.inventory.dtos.InventoryResponseDto;
import com.danielfreitassc.inventory.models.InventoryEntity;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    @Mapping(source = "productEntity.id", target = "productId")
    InventoryResponseDto entityToDto(InventoryEntity inventoryEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source =  "productId", target = "productEntity.id")
    InventoryEntity dtoToEntity(InventoryRequestDto inventoryRequestDto);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source =  "productId", target = "productEntity.id")
    void toUpdate(InventoryRequestDto inventoryRequestDto, @MappingTarget InventoryEntity inventoryEntity);
}
