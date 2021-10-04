package ru.mirea.springpizzashop.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.mirea.springpizzashop.models.Product;
import ru.mirea.springpizzashop.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProductService productService;

    @MockBean
    ProductRepository productRepository;

    @Test
    void addProduct() {
        Product product = new Product();
        product.setName("test");
        product.setDescription("long_string");
        product.setPrice(10);
        product.setId(1L);
        productService.addProduct(product);
        Mockito.when(productService.getAllProducts()).thenReturn(Collections.singletonList(product));
    }

    @Test
    void findAll() {
        Product product1 = new Product();
        product1.setName("test");
        product1.setDescription("long_string");
        product1.setPrice(10);
        product1.setId(1L);
        Product product2 = new Product();
        product2.setName("test2");
        product2.setDescription("long_string");
        product2.setPrice(101);
        product2.setId(2L);
        productService.addProduct(product1);
        productService.addProduct(product2);
        Mockito.when(productService.getAllProducts()).thenReturn(Arrays.asList(product1, product2));
    }

    @Test
    void findById() {
        Product product1 = new Product();
        product1.setName("test");
        product1.setDescription("long_string");
        product1.setPrice(10);
        product1.setId(1L);
        Mockito.when(productService.getProductById(1L)).thenReturn(product1);
    }

}
