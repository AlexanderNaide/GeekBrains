package ru.gb.spring_rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring_rest.model.SubCategory1;
import ru.gb.spring_rest.repository.SubCategory1Repository;

import java.util.Optional;

@Service
public class SubCategory1Service {
    private SubCategory1Repository subCategory1Repository;

    @Autowired
    public void setCategoryRepository(SubCategory1Repository subCategory1Repository) {
        this.subCategory1Repository = subCategory1Repository;
    }

    public Optional<SubCategory1> findCatByName(String title){
        return subCategory1Repository.findByTitle(title);
    }

    public void addCat(SubCategory1 subCategory1){
        subCategory1Repository.save(subCategory1);
    }
}
