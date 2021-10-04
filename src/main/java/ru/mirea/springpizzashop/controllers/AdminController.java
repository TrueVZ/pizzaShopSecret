package ru.mirea.springpizzashop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.springpizzashop.models.Product;
import ru.mirea.springpizzashop.services.ProductService;
import ru.mirea.springpizzashop.services.ProductTypeService;
import ru.mirea.springpizzashop.services.UserService;

import java.io.IOException;


/**
 * Контроллер с путями которые доступны только пользователями с правами админа
 */
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final ProductService productService;
    private final ProductTypeService productTypeService;

    /**
     * Ручка стартовой страницы
     * @param model
     * @return
     */
    @GetMapping
    public String index(Model model){
        return "admin/index";
    }


    /**
     * Ручка для получение всех доступных продуктов в системе
     * @param model
     * @return
     */
    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("listProducts", productService.getAllProducts());
        model.addAttribute("listProductType", productTypeService.getAllProductTypes());
        return "admin/products";
    }

    /**
     * Ручка для получения детальной информации о продукте
     * @param id - id продукта по которому получается информация
     * @param model
     * @return
     */
    @GetMapping("/products/{id}")
    public String detailProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.getProductById((long) id));
        model.addAttribute("listProductType", productTypeService.getAllProductTypes());
        return "admin/detail_product";
    }

    /**
     * Удаление продукта по ид
     * @param id - id удаляемого продукта
     * @return
     */
    @GetMapping("/delete_product/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct((long) id);
        return "redirect:/admin/products";
    }

    /**
     * Создания продукта
     * @param productTypeId - ид типа продукта
     * @param name - наименование продукта
     * @param price - цена продукта
     * @param description - описание продукта
     * @param image - изображения продукта
     * @return
     */
    @PostMapping("/products/create")
    public String createProduct(@RequestParam int productTypeId, @RequestParam String name, @RequestParam int price, @RequestParam String description, @RequestParam MultipartFile image) {
        Product product = new Product();
        product.setProductType(productTypeService.getProductTypeById((long) productTypeId));
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        try {
            product.setPicture(image.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }

        productService.addProduct(product);

        return "redirect:/admin/products";
    }
}
