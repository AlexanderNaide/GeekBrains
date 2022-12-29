package ru.gb.spring_rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring_rest.model.Manufacturer;
import ru.gb.spring_rest.repository.ManufacturerRepository;

import java.util.Optional;

@Service
public class ManufacturerService {
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    public void setCategoryRepository(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public Optional<Manufacturer> findManByName(String title){
        return manufacturerRepository.findByTitle(title);
    }

    public void addMan(Manufacturer manufacturer){
        manufacturerRepository.save(manufacturer);
    }
}
