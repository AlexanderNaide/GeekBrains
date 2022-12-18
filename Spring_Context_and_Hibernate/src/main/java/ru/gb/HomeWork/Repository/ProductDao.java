package ru.gb.HomeWork.Repository;

import ru.gb.HomeWork.model.Product;
import java.util.List;

public interface ProductDao {

    void insert(Product product);

    Product get(Long id);

    void delete(Product product);

    List<Product> getAll();

}
