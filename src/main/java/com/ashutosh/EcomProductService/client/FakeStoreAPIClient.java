package com.ashutosh.EcomProductService.client;

import com.ashutosh.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.ashutosh.EcomProductService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreAPIURL;
    @Value("${fakestore.api.path.product}")
    private String fakeStoreAPIPathProduct;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder,
                              @Value("${fakestore.api.url}") String fakeStoreAPIURL) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIURL = fakeStoreAPIURL;
    }
    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String createProductUrl = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> response =
                restTemplate.postForEntity(createProductUrl,fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return response.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String getAllProductsUrl = fakeStoreAPIURL+fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> responseArray =
                restTemplate.getForEntity(getAllProductsUrl,FakeStoreProductResponseDTO[].class);
        return List.of(responseArray.getBody());
    }

    public FakeStoreProductResponseDTO getProductsById(int id){
        String getProductsUrl = fakeStoreAPIURL+fakeStoreAPIPathProduct+"/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> response =
                restTemplate.getForEntity(getProductsUrl,FakeStoreProductResponseDTO.class);
        return response.getBody();
    }

    public boolean deleteProduct(int id){
        String deleteProductUrl = fakeStoreAPIURL+fakeStoreAPIPathProduct+"/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductUrl);
        return true;
    }

    public FakeStoreProductResponseDTO updateProduct(int id, FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String updateProductUrl = fakeStoreAPIURL+fakeStoreAPIPathProduct+"/"+id;
        FakeStoreProductResponseDTO fakeStoreProductResponse = getProductsById(id);
        return null;
    }
}
