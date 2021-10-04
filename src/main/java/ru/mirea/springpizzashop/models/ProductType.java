package ru.mirea.springpizzashop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Описание модели типа продукта
 */
@Entity
@Data
@Table(name = "products_type")
public class ProductType {
    /** Id типа продукта */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Long id;
    /** Наименование типа продукта */
    @NotNull
    @Column(name = "product_type_name")
    private String name;
    /** Продукты этого типа */
    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> productList;

}
