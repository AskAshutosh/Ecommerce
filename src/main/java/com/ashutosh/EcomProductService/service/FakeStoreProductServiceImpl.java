package com.ashutosh.EcomProductService.service;

import com.ashutosh.EcomProductService.Model.Product;
import com.ashutosh.EcomProductService.dto.ProductListResponseDTO;
import com.ashutosh.EcomProductService.dto.ProductRequestDTO;
import com.ashutosh.EcomProductService.dto.ProductResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeProductService")
public class FakeStoreProductServiceImpl implements ProductService{
    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        String productCallUrl = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO[]> productResponseArray =
      restTemplate.getForEntity(productCallUrl, ProductResponseDTO[].class);
        ProductListResponseDTO responseDTO = new ProductListResponseDTO();
        for(ProductResponseDTO productResponse: productResponseArray.getBody())
            responseDTO.getProducts().add(productResponse);
        return responseDTO;
    }

    @Override
    public ProductResponseDTO getProductsById(int id) {
        String productCallUrl = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse =
                restTemplate.getForEntity(productCallUrl,ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        String createProductUrl = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse =
                restTemplate.postForEntity(createProductUrl,productRequestDTO, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public boolean deleteProduct(int id) {
        String deleteProductUrl = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductUrl);
        return true;
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO) {
        String updateProductUrl = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductResponseDTO productResponse =
                restTemplate.patchForObject(updateProductUrl, productRequestDTO, ProductResponseDTO.class);
        return productResponse;
    }
}
