package com.ashutosh.EcomProductService.service;

import com.ashutosh.EcomProductService.Model.Product;
import com.ashutosh.EcomProductService.dto.ProductResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductResponseDTO getAllProducts();
    ProductResponseDTO getProductsById(int id);
    Product createProduct(Product product);
    Product deleteProduct(int id);
    Product updateProduct(int id, Product product);

}
