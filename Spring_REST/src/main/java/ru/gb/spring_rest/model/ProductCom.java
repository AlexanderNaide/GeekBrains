package ru.gb.spring_rest.model;

import lombok.Data;

@Data
public class ProductCom extends Product{

    private Long id;

    private SubCategory1 subCategory1;
//
//    private SubCategory2 subCategory2;
//
//    private Long article;

    private String title;

    private Double price;

    public ProductCom(Long id, String title, Double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public ProductCom(Long id, SubCategory1 subCategory1, String title, Double price) {
        this(id, title, price);
        this.subCategory1 = subCategory1;
    }
}
