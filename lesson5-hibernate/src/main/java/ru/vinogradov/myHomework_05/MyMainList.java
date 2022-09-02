package ru.vinogradov.myHomework_05;

import ru.vinogradov.myModel.Product;
import ru.vinogradov.myModel.ProductFields;

public class MyMainList {

    ProductRepository productRepository;

    public MyMainList(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void doSave() {
        productRepository.connect(() -> {
            productRepository.save("Milk", 105);
            productRepository.save("Meat", 500);
            productRepository.save("Eggs", 87);
        });
        doFindAll();
    }

    public void doFindAll() {
        productRepository.connect(() -> productRepository.findAll());
        productRepository.repositoryInfo();
        System.out.println("----------------------------------------");
    }

    public void doFindById() {
        productRepository.connect(() -> {
            Product product = productRepository.findById(2L);
            System.out.println(product);
        });
        System.out.println("----------------------------------------");
    }

    public void doUpdate() {
        productRepository.connect(() -> {
            productRepository.update(1L, ProductFields.PRODUCT_NAME, "Cheese");
        });
        doFindAll();

        productRepository.connect(() -> {
            productRepository.update(1L, ProductFields.PRICE, 50);
        });
        doFindAll();
    }

    public void doDeleteById() {
        productRepository.connect(() -> {
            productRepository.deleteById(2L);
        });
        doFindAll();
    }

    public void stop() {
        productRepository.stop();
    }


}
