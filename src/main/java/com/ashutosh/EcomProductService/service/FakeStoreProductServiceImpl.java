package com.ashutosh.EcomProductService.service;

import com.ashutosh.EcomProductService.client.FakeStoreAPIClient;
import com.ashutosh.EcomProductService.dto.*;
import com.ashutosh.EcomProductService.exception.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.ashutosh.EcomProductService.mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.ashutosh.EcomProductService.mapper.ProductMapper.fakeStoreProductResponseToProductResponse;

@Service("fakeProductService")
public class FakeStoreProductServiceImpl implements ProductService{
    RestTemplateBuilder restTemplateBuilder;
    FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<FakeStoreProductResponseDTO> productResponseDTOList = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(FakeStoreProductResponseDTO fakeStoreProductResponseDTO: productResponseDTOList){
            productListResponseDTO.getProducts().add(fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO));
        }
        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductsById(int id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponse = fakeStoreAPIClient.getProductsById(id);
        if(fakeStoreProductResponse==null)
            throw new ProductNotFoundException("Product not found with id: "+id);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponse);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public boolean deleteProduct(int id) {
        return fakeStoreAPIClient.deleteProduct(id);
    }

    @Override

    public ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO){

//        String updateProductUrl = "https://fakestoreapi.com/products/"+id;
//        ProductResponseDTO updatedProduct = getProductsById(id);
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ProductResponseDTO productResponse =
//                restTemplate.patchForObject(updateProductUrl, productRequestDTO, ProductResponseDTO.class);
//        return productResponse;
        return null;
    }

}
