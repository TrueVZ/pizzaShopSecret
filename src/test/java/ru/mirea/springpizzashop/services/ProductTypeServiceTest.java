package ru.mirea.springpizzashop.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.mirea.springpizzashop.models.Product;
import ru.mirea.springpizzashop.models.ProductType;
import ru.mirea.springpizzashop.repositories.ProductTypeRepository;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProductTypeServiceTest {

    @Autowired
    ProductTypeService productTypeService;

    @MockBean
    ProductTypeRepository productTypeRepository;


    @Test
    void addProductType() {
        ProductType productType = new ProductType();
        productType.setId(1L);
        productType.setName("testProductType");
        Product product = new Product();
        product.setName("testProduct");
        product.setPrice(10);
        product.setDescription("long_string");
        productType.setProductList(Collections.singletonList(product));
        productTypeService.addProductType(productType);

        Mockito.when(productTypeService.getAllProductTypes()).thenReturn(Collections.singletonList(productType));
    }

    @Test
    void findProductTypeById() {
        ProductType productType = new ProductType();
        productType.setId(1L);
        productType.setName("testProductType");
        Product product = new Product();
        product.setName("testProduct");
        product.setPrice(10);
        product.setDescription("long_string");
        productType.setProductList(Collections.singletonList(product));
        productTypeService.addProductType(productType);

        Mockito.when(productTypeService.getProductTypeById(1L)).thenReturn(productType);
    }
}
