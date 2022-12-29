package ru.gb.spring_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring_rest.model.SubCategory3;

import java.util.Optional;

public interface SubCategory3Repository extends JpaRepository<SubCategory3, Long> {

    Optional<SubCategory3> findByTitle(String title);
}
