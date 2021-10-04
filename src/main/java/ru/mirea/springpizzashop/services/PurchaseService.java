package ru.mirea.springpizzashop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.springpizzashop.models.Purchase;
import ru.mirea.springpizzashop.repositories.PurchaseRepository;

import java.util.List;

/**
 * Сервис для работы с покупками
 */
@Service
@RequiredArgsConstructor
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    /**
     * Добавление покупки
     * @param purchase
     * @see Purchase
     */
    public void addPurchase(Purchase purchase){
        purchaseRepository.save(purchase);
    }

    /**
     * Получения покупки
     * @param userId - ид пользователя
     * @param productId - ид продукта
     * @return Покупка
     */
    public Purchase getPurchaseByUserIdAndProductId(long userId, long productId){
        return purchaseRepository.findByUserIdAndProductId(userId, productId);
    }


    /**
     * Получение список покупок пользователя
     * @param userId ид пользователя
     * @return Список покупок
     */
    public List<Purchase> getAllPurchaseUser(long userId){
        return purchaseRepository.findAllByUserId(userId);
    }

    /**
     * Удаление покупки
     * @param id - ид покупки
     */
    public void deletePurchase(long id){
        purchaseRepository.deleteById(id);
    }

    /**
     * Удаление всех покупок пользователя
     * @param userId - ид пользователя
     */
    public void deleteAllPurchaseByUserId(long userId){
        purchaseRepository.deleteAllByUserId(userId);
    }

}
