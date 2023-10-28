package com.ashutosh.EcomProductService.mapper;

import com.ashutosh.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.ashutosh.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.ashutosh.EcomProductService.dto.ProductRequestDTO;
import com.ashutosh.EcomProductService.dto.ProductResponseDTO;

public class ProductMapper {
    public static FakeStoreProductRequestDTO productRequestToFakeStoreProductRequest(ProductRequestDTO productRequestDTO){
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());
        return fakeStoreProductRequestDTO;
    }

    public static ProductResponseDTO fakeStoreProductResponseToProductResponse(FakeStoreProductResponseDTO fakeStoreProductResponseDTO){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());
        return productResponseDTO;
    }
}
