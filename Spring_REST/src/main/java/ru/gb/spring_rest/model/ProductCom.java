package ru.gb.spring_rest.model;

import lombok.Data;

@Data
public class ProductCom {

    private Long id;

    private SubCategory1 subCategory1;

    private SubCategory2 subCategory2;

    private Long article;

    private String title;

    private Double price;
}
