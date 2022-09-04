package ru.vinogradov.myHomework_05;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.vinogradov.myModel.Product;
import ru.vinogradov.myModel.ProductFields;

import java.util.List;

public class ProductRepository<T> implements ConnectDB {

    private List<Product> products = null;

    private final EntityManagerFactory entityManagerFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();


    public void repositoryInfo() {
        if (products == null) {
            System.out.println("Список продуктов пуст.");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> findAll() {
        products = entityManager.createQuery("select p from Product p", Product.class)
                .getResultList();
        return products;
    }

    public boolean save(String nameProduct, Integer price) {
        entityManager.persist(new Product(nameProduct, price));
        return true;
    }

    public boolean update (Long Id, ProductFields productFld, T obj) {
        if (productFld == ProductFields.PRODUCT_NAME && obj instanceof String) {
            Product product = findById(Id);
            String newNameProduct = (String) obj;
            product.setProductName(newNameProduct);
            return true;
        }
        if (productFld == ProductFields.PRICE && obj instanceof Integer) {
            Product product = findById(Id);
            Integer newPrice = (Integer) obj;
            product.setPrice(newPrice);
            return true;
        }
        return false;
    }

    public boolean deleteById(Long Id) {
        Product product = findById(Id);
        entityManager.remove(product);
        return true;
    }

    @Override
    public void connect(OperationDB operationDB) {
        entityManager.getTransaction().begin();
        operationDB.execute();
        entityManager.getTransaction().commit();
    }
    @Override
    public void stop() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
