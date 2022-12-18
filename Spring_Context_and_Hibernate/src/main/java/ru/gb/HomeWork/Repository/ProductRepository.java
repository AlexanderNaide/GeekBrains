package ru.gb.HomeWork.Repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.HomeWork.model.Product;

import java.util.List;

@Component
@Scope("prototype")
public class ProductRepository extends Repository implements ProductDao{


    @Override
    public void insert(Product product) {
        executeInTransaction(entityManager ->
                entityManager.persist(product));
    }

    @Override
    public Product get(Long id) {
        return executeForEntityManager(entityManager ->
            entityManager.find(Product.class, id)
        );
    }

    @Override
    public void delete(Product product) {
        executeInTransaction(entityManager ->
                entityManager.remove(product));
    }

    @Override
    public List<Product> getAll() {
        return executeForEntityManager(entityManager ->
                entityManager.createQuery("select p from Product p", Product.class).getResultList()
        );
    }

}
