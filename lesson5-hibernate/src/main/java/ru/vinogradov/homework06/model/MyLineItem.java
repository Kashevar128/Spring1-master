package ru.vinogradov.homework06.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "line_items")
@NoArgsConstructor
public class MyLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private MyProduct myProduct;

    @ManyToOne
    private MyCustomer myCustomer;


    private Long quantity;

    private String color;

    private String size;
}
