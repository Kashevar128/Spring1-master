package ru.vinogradov.homework_02;

public interface ProductRepository {

    Product findProductById(Long id);

    void addProduct(Long id, Product product);
}
