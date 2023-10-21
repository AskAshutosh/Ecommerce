package com.ashutosh.EcomProductService.controller;

import com.ashutosh.EcomProductService.dto.ProductResponseDTO;
import com.ashutosh.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    @Qualifier("fakeProductService")

    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
/*
        ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("Galaxy S23+");
        p1.setCategory("Smartphone");
        p1.setPrice(150000);
        p1.setDescription("Samsung flagship phone in 2023");
        p1.setImage("Random image url");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(1);
        p2.setTitle("Galaxy Tab");
        p2.setCategory("Tablet PC");
        p2.setPrice(51000);
        p2.setDescription("Samsung flagship tablet in 2023");
        p2.setImage("Random image url");

        List<ProductResponseDTO> products = Arrays.asList(p1,p2);
        return ResponseEntity.ok(products);

 */
        ProductResponseDTO productResponseDTO = productService.getAllProducts();
        return ResponseEntity.ok(productResponseDTO);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") Integer id){
        ProductResponseDTO productResponseDTO = productService.getProductsById(id);
        return ResponseEntity.ok(productResponseDTO);
    }



}
