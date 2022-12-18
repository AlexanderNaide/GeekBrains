package ru.gb.HomeWork.Repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.HomeWork.model.Product;
import ru.gb.HomeWork.model.User;

import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class Repository {

    private FactoryService factoryService;

    @Autowired
    public void setFactoryService(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    protected <R> R executeForEntityManager(Function<EntityManager, R> function){
        EntityManager em = factoryService.getManager();
        try{
            return function.apply(em);
        }finally {
            if (em != null){
                em.close();
            }
        }
    }

    protected void executeInTransaction(Consumer<EntityManager> consumer){
        EntityManager em = factoryService.getManager();
        try{
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            if (em != null){
                em.close();
            }
        }
    }

/*    public void addBuy(Long userId, Long productId) {
        User user = executeForEntityManager(entityManager ->
            entityManager.find(User.class, userId)
        );
        Product product = executeForEntityManager(entityManager ->
                entityManager.find(Product.class, productId)
        );
        executeInTransaction(entityManager -> {
            user.getProducts().add(product);
            product.getUsers().add(user);
        });
    }*/

/*    public void addBuy(Long userId, Long productId) {
        executeInTransaction(entityManager -> {
            User user = entityManager.find(User.class, userId);
            Product product = entityManager.find(Product.class, productId);
            user.getProducts().add(product);
            product.getUsers().add(user);
        });
    }*/

    public void addBuy(Long userId, Long productId) {
        executeInTransaction(entityManager -> {
            entityManager.find(User.class, userId).getProducts().add(entityManager.find(Product.class, productId));
        });
    }
}
