package ru.mirea.springpizzashop.models;

import lombok.*;

import javax.persistence.*;

/**
 * Описание модели покупки
 */
@Entity
@Table(name = "cart")
@Data
public class Purchase {
    /** Id покупки */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /** Id пользователя  */
    @Column(name = "user_id")
    Long userId;
    /** Id продукта */
    @Column(name = "product_id")
    Long productId;
    /** Количествоы продукта */
    @Column(name = "product_count")
    int productCount;


}
