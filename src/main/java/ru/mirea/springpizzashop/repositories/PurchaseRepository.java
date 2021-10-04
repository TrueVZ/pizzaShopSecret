package ru.mirea.springpizzashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.springpizzashop.models.Purchase;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Репозиторий для работы с бд покупок
 */
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    /** Поиск покупки по id пользователя и id продукта
     *
     * @param userId - id пользователя
     * @param productId - id продукта
     * @return Покупка
     * @see Purchase
     */
    Purchase findByUserIdAndProductId(long userId, long productId);

    /**
     *  Поиск покупки по id пользователя и id покупки
     * @param id ид покупки
     * @param userId ид пользователя
     * @return Покупка
     */
    Purchase findByIdAndUserId(long id, long userId);

    /**
     * Поиск всех покупок пользователя
     * @param userId ид пользователя
     * @return Покупка
     */
    List<Purchase> findAllByUserId(long userId);

    /**
     * Удаление покупки по id
     * @param id - ид покупки
     * @return id удаленной покупки
     */
    Long deleteById(long id);

    /**
     * Поиск покупки по id
     * @param id ид покупки
     * @return Покупка
     */
    Purchase findById(long id);

    /**
     * Удаление всех покупок пользователя
     * @param userId id пользователя
     * @return ид пользователя у которго удалили продукты
     */
    @Transactional
    Long deleteAllByUserId(long userId);
}
