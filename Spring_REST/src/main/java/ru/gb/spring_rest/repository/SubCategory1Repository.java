package ru.gb.spring_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring_rest.model.SubCategory1;

import java.util.Optional;

public interface SubCategory1Repository extends JpaRepository<SubCategory1, Long> {

    Optional<SubCategory1> findByTitle(String title);
}
