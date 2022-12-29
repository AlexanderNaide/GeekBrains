package ru.gb.spring_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring_rest.model.Manufacturer;

import java.util.Optional;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    Optional<Manufacturer> findByTitle(String title);
}
