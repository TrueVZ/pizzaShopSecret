package ru.mirea.springpizzashop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.springpizzashop.models.ProductType;
import ru.mirea.springpizzashop.repositories.ProductTypeRepository;

import java.util.List;

/**
 * Сервис для работы с категориями продуктов
 */
@Service
@RequiredArgsConstructor
public class ProductTypeService {
    private ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    /**
     * Создание нового типа продуктов
     * @param productType
     * @see ProductType
     */
    public void addProductType(ProductType productType){
        productTypeRepository.save(productType);
    }


    /**
     * Получение типа продуктов
     * @param id - ид типа
     * @return Категории продуктов
     * @see ProductType
     */
    public ProductType getProductTypeById(Long id){
        return productTypeRepository.findProductTypeById(id);
    }

    /**
     * Получение списка категорий
     * @return список категорий
     */
    public List<ProductType> getAllProductTypes(){
        return productTypeRepository.findAll();
    }
}
