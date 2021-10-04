package ru.mirea.springpizzashop.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Описание модели продукта
 */
@Data
@Entity
@Table(name = "products")
public class Product {
    /** Id продукта */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    /** Название продукта */
    @Column(name = "product_name")
    private String name;
    /** Цена продукта */
    @Column(name = "price")
    private int price;
    /** Описание продукта */
    @Column(name = "description")
    private String description;
    /** Ссылка на изображения продукта */
    @Column(name = "image_url")
    private String image_url;

    /** Изображение продукта */
    @Lob
    @Column(name = "picture")
    private byte[] picture;

    /** Тип продукта */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;


}
