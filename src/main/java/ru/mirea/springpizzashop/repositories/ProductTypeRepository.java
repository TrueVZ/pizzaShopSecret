package ru.mirea.springpizzashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.springpizzashop.models.ProductType;

/**
 * Репозиторий для работы с бд типов продуктов
 */
@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    /** Удалени типа продукта по id
     *
     * @param id id категории продукта
     * @return ид удаденной категории
     */
    Long deleteProductTypeById(Long id);

    /** Поиск типа продукта по id
     * @param id id категории продукта
     * @return катерогия продуктов
     */
    ProductType findProductTypeById(Long id);

}
