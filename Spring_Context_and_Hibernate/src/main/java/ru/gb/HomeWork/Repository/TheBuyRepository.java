package ru.gb.HomeWork.Repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.HomeWork.Repository.Parents.BuyDao;
import ru.gb.HomeWork.Repository.Parents.ProductDao;
import ru.gb.HomeWork.Repository.Parents.Repository;
import ru.gb.HomeWork.model.Product;
import ru.gb.HomeWork.model.TheBuy;
import ru.gb.HomeWork.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class TheBuyRepository extends Repository implements BuyDao {


    @Override
    public void insert(TheBuy buy) {
        executeInTransaction(entityManager ->
                entityManager.persist(buy));
    }

    @Override
    public TheBuy get(Long id) {
        return executeForEntityManager(entityManager ->
                entityManager.find(TheBuy.class, id)
        );
    }

    @Override
    public void delete(TheBuy buy) {
        executeInTransaction(entityManager ->
                entityManager.remove(buy));
    }

    @Override
    public List<TheBuy> getAllBuys() {
        return executeForEntityManager(entityManager ->
                entityManager.createQuery("from TheBuy", TheBuy.class).getResultList()
        );
    }

    @Override
    public List<TheBuy> getBuysFromUser(User user) {
        return executeForEntityManager(entityManager -> {
            List<TheBuy> list = entityManager.createQuery("select b from TheBuy b where b.buyer = :name", TheBuy.class).setParameter("user", user).getResultList();
            list.forEach(b -> b.setProductsList(new ArrayList<>(b.getProductsList())));
            return list;
            }
        );
    }

    @Override
    public void save(TheBuy buy) {
        executeInTransaction(entityManager ->
                entityManager.merge(buy));
    }

}
