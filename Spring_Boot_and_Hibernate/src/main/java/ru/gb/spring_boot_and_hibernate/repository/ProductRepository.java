package ru.gb.spring_boot_and_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring_boot_and_hibernate.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByPriceGreaterThan(Double min);
    List<Product> findProductsByPriceGreaterThanAndPriceLessThan(Double min, Double max);
}
