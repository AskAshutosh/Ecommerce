package com.ashutosh.EcomProductService.controller;

import com.ashutosh.EcomProductService.dto.ProductListResponseDTO;
import com.ashutosh.EcomProductService.dto.ProductRequestDTO;
import com.ashutosh.EcomProductService.dto.ProductResponseDTO;
import com.ashutosh.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {


    ProductService productService;
    @Autowired //optional when using constructor injection
    public ProductController(@Qualifier("fakeProductService")ProductService productService) {
        this.productService = productService;
    }

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
        ProductListResponseDTO productResponse = productService.getAllProducts();
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") Integer id){
        ProductResponseDTO productResponseDTO = productService.getProductsById(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Integer id){
        Boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
        //TODO : Delete is showing true even for non existing product; fix logic for delete
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") Integer id,
                                        @RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = productService.updateProduct(id, productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
        //TODO: Update patch function
    }

}
