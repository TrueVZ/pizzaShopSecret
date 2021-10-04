package ru.mirea.springpizzashop.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.mirea.springpizzashop.models.User;
import ru.mirea.springpizzashop.repositories.UserRepository;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Test
    void addUser(){
        User user = new User("test", "password", "email");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addUser(user);

        Mockito.when(userRepository.findByUsername("test")).thenReturn(user);
    }

    @Test
    void findAllUser(){
        User user = new User("test1", "password2", "email");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        User user2 = new User("test321", "passwo321rd", "ema321il");
        user.setPassword(bCryptPasswordEncoder.encode(user2.getPassword()));
        userService.addUser(user);
        userService.addUser(user2);

        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(user, user2));
    }

}
