package org.example.fakestoreapibackend2;

import org.example.fakestoreapibackend2.dto.FakeStoreProductDto;
import org.example.fakestoreapibackend2.integration.FakeStoreApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Backend2GruppuppgiftApplicationTests {

    @Autowired
    private FakeStoreApiClient fakeStoreApiClient;

    @Test
    void contextLoads() {
    }
    @Test
    void testFakeStoreApiConnection() {
        // Test การเชื่อมต่อ FakeStore API
        List<FakeStoreProductDto> products = fakeStoreApiClient.getAllProducts();

        // Verify ว่าได้ข้อมูลมา
        assertNotNull(products);
        assertFalse(products.isEmpty());

        System.out.println("Successfully connected to FakeStore API");
        System.out.println("Found " + products.size() + " products");

        // แสดงสินค้า 3 ตัวแรก
        products.stream()
                .limit(3)
                .forEach(product ->
                        System.out.println("- " + product.getTitle() + " ($" + product.getPrice() + ")")
                );

    }
        @Test
        void testGetSingleProduct() {
            // Test เรียกสินค้าตัวเดียว
            FakeStoreProductDto product = fakeStoreApiClient.getProductById(1L);

            assertNotNull(product);
            assertEquals(1L, product.getId());
            assertNotNull(product.getTitle());
            assertNotNull(product.getPrice());

            System.out.println("Single product test passed");
            System.out.println("Product: " + product.getTitle());
        }
    }
