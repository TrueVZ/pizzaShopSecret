package ru.mirea.springpizzashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.springpizzashop.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Поиск пользователя по никнейму
     * @param username никнейм пользователя
     * @return
     */
    User findByUsername(String username);

    /**
     * Поиск пользователя по email
     * @param email email пользователя
     * @return
     */
    User findByEmail(String email);

    /**
     * Поиск пользователи по никнейму или по почте
     * @param username никнейм пользователя
     * @param email почта пользователя
     * @return
     */
    User findByUsernameOrEmail(String username, String email);
}
