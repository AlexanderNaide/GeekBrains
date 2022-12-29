package ru.gb.spring_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring_rest.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByTitle(String title);
}
