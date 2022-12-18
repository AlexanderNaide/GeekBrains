package ru.gb.HomeWork.Repository;

import ru.gb.HomeWork.model.User;
import java.util.List;

public interface UserDao {

    void insert(User user);

    User get(Long id);

    void delete(User user);

    List<User> getAll();

}
