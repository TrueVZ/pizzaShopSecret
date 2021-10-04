package ru.mirea.springpizzashop.services;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.mirea.springpizzashop.models.Product;
import ru.mirea.springpizzashop.models.Purchase;
import ru.mirea.springpizzashop.models.User;
import ru.mirea.springpizzashop.repositories.ProductRepository;
import ru.mirea.springpizzashop.repositories.PurchaseRepository;
import ru.mirea.springpizzashop.repositories.UserRepository;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PurchaseServiceTest {
    @Autowired
    PurchaseService purchaseService;
    @MockBean
    PurchaseRepository purchaseRepository;


    @Test
    void addPurchase(){
        User user = new User("test", "password", "email");
        user.setId(1L);

        Product product = new Product();
        product.setName("test");
        product.setDescription("long_string");
        product.setPrice(10);
        product.setId(1L);

        Purchase purchase = new Purchase();
        purchase.setId(1L);
        purchase.setProductId(1L);
        purchase.setUserId(user.getId());
        purchaseService.addPurchase(purchase);
        Mockito.when(purchaseRepository.findAll()).thenReturn(Collections.singletonList(purchase));
    }

    @Test
    void getAllPurchaseUser() {
        User user = new User("test", "password", "email");
        user.setId(2L);

        Product product = new Product();
        product.setName("test");
        product.setDescription("long_string");
        product.setPrice(10);
        product.setId(1L);

        Purchase purchase = new Purchase();
        purchase.setId(1L);
        purchase.setProductId(1L);
        purchase.setUserId(user.getId());
        purchaseService.addPurchase(purchase);
        Mockito.when(purchaseService.getAllPurchaseUser(2L)).thenReturn(Collections.singletonList(purchase));
    }

    @Test
    void deleteAllPurchaseUser(){
        User user = new User("test", "password", "email");
        user.setId(2L);

        Product product = new Product();
        product.setName("test");
        product.setDescription("long_string");
        product.setPrice(10);
        product.setId(1L);

        Purchase purchase = new Purchase();
        purchase.setId(1L);
        purchase.setProductId(1L);
        purchase.setUserId(user.getId());
        purchaseService.addPurchase(purchase);
        purchaseService.deleteAllPurchaseByUserId(2L);
        Mockito.when(purchaseService.getAllPurchaseUser(2L)).thenReturn(Collections.emptyList());
    }
}
