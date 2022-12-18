package ru.gb.HomeWork.Repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.HomeWork.model.Product;
import ru.gb.HomeWork.model.User;

import java.util.List;

@Component
@Scope("prototype")
public class UserRepository extends Repository implements UserDao{


    @Override
    public void insert(User user) {
        executeInTransaction(entityManager ->
                entityManager.persist(user));
    }

    @Override
    public User get(Long id) {
        return executeForEntityManager(entityManager ->
            entityManager.find(User.class, id)
        );
    }

    @Override
    public void delete(User user) {
        executeInTransaction(entityManager ->
                entityManager.remove(user));
    }

    @Override
    public List<User> getAll() {
        return executeForEntityManager(entityManager ->
                entityManager.createQuery("select p from User p", User.class).getResultList()
        );
    }

}
