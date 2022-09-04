package ru.vinogradov.homework06.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.titov.model.User;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customers")
@NoArgsConstructor
public class MyCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private MyUser user;

    @OneToMany(mappedBy = "myCustomer")
    private List<MyLineItem> products;


}
