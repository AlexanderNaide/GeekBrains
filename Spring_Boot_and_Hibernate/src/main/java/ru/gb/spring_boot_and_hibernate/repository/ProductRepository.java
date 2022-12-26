package ru.gb.spring_boot_and_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.spring_boot_and_hibernate.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> searchAllByTitleContainingAndPriceGreaterThan(String value, Double min);
    List<Product> searchAllByTitleContainingAndPriceGreaterThanAndPriceLessThan(String value, Double min, Double max);
}
