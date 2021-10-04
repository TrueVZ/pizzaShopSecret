package ru.mirea.springpizzashop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.springpizzashop.models.Product;
import ru.mirea.springpizzashop.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Сервис для работы с продуктами
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    /** Репозиторий для работы с продуктами */
    private ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Получения продукта по id
     * @param id ид продукта
     * @return Продукт
     * @see Product
     */
    @Transactional
    public Product getProductById(Long id){
        return productRepository.findProductById(id);
    }

    /**
     * Получение всех продуктов
     * @return Список продуктов
     */
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    /**
     * Получения всех продуктов одной категории
     * @param id - Ид категории продуктов
     * @return Список продуктов
     */
    public List<Product> getAllProductByTypeId(Long id){
        return productRepository.findAllByProductTypeId(id);
    }

    /**
     * Создание нового продукта
     * @param product
     * @see Product
     */
    public void addProduct(Product product){
        productRepository.save(product);
    }

    /**
     * Получение изображения продукта
     * @param id - ид продукта
     * @return Массив бит изображения продукта
     */
    @Transactional
    public byte[] getPictureById(Long id){
        return productRepository.getPictureById(id);
    }

    /**
     * Удаления продукта
     * @param id - ид продукта
     */
    @Transactional
    public void deleteProduct(Long id){
        productRepository.deleteProductById(id);
    }
}
