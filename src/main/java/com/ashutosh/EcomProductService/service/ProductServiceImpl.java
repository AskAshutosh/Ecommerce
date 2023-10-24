package com.ashutosh.EcomProductService.service;

import com.ashutosh.EcomProductService.Model.Product;
import com.ashutosh.EcomProductService.dto.ProductListResponseDTO;
import com.ashutosh.EcomProductService.dto.ProductRequestDTO;
import com.ashutosh.EcomProductService.dto.ProductResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public ProductListResponseDTO getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductsById(int id) {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }
    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO product) {
        return null;
    }
}
