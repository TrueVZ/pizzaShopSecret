package ru.mirea.springpizzashop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mirea.springpizzashop.models.Product;
import ru.mirea.springpizzashop.models.Role;
import ru.mirea.springpizzashop.models.User;
import ru.mirea.springpizzashop.repositories.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    /**
     * Создание нового пользователя
     * @param user
     * @return true - если пользовательно удачно создан, false - если пользователь с таким никнеймом либо почтой уже создан
     * @see User
     */
    public boolean addUser(User user) {
        User user1 = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
        if (user1 != null){
            return false;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (!user.getUsername().equals("admin"))
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        else
            user.setRoles(new HashSet<>(Arrays.asList(new Role(1L, "ROLE_USER"), new Role(2L, "ROLE_ADMIN"))));
        user.setActive(true);
        userRepository.save(user);
        return true;
    }

    /**
     * Получение пользователя
     * @param s никнейм пользователя
     * @return User
     * @throws UsernameNotFoundException
     * @see User
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }
}
