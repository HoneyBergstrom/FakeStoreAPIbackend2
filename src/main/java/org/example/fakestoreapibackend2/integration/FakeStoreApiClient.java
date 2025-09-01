package org.example.fakestoreapibackend2.integration;

import org.example.fakestoreapibackend2.dto.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreApiClient {
    private final RestTemplate restTemplate;

    @Value("${fakestore.api.base-url:https://fakestoreapi.com}")
    private String baseUrl;

    public FakeStoreApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        String url = baseUrl + "/products";

        FakeStoreProductDto[] products = restTemplate.getForObject(
                url,
                FakeStoreProductDto[].class
        );

        return products != null ? Arrays.asList(products) : List.of();
    }

    public FakeStoreProductDto getProductById(Long id) {
        String url = baseUrl + "/products/" + id;

        return restTemplate.getForObject(url, FakeStoreProductDto.class);
    }
}


