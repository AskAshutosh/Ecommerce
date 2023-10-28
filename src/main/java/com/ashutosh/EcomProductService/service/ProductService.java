package com.ashutosh.EcomProductService.service;

import com.ashutosh.EcomProductService.Model.Product;
import com.ashutosh.EcomProductService.dto.ProductListResponseDTO;
import com.ashutosh.EcomProductService.dto.ProductRequestDTO;
import com.ashutosh.EcomProductService.dto.ProductResponseDTO;
import com.ashutosh.EcomProductService.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductsById(int id) throws ProductNotFoundException;
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    boolean deleteProduct(int id);
    ProductResponseDTO updateProduct(int id, ProductRequestDTO product) throws ProductNotFoundException;

}
