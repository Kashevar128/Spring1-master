package ru.vinogradov.myModel;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column
    private String productName;

    @NonNull
    @Column
    private Integer price;

    public Product(String productName, Integer price) {
        this.productName = productName;
        this.price = price;
    }
}
