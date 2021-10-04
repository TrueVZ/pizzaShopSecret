package ru.mirea.springpizzashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mirea.springpizzashop.models.Product;

import java.util.List;

/**
 * Репозиторий для работы с бд продуктов
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Поиск изображения продукта по его id
     * @param id - ид продукта
     * @return Изображение в виде массива байт
     */
    @Query("select p.picture from Product p where p.id = :id")
    byte[] getPictureById(Long id);

    /** Поиск всех продуктов по id категории
     * @param productTypeId - id категории
     * @return Список продукто
     */
    List<Product> findAllByProductTypeId(Long productTypeId);

    /** Поиск продукта по id
     * @param id ид продукта
     * @return Продукт
     * @see Product
     */
    Product findProductById(Long id);

    /** Удаления продукта по id
     * @param id ид продукта
     */
    void deleteProductById(Long id);

}
