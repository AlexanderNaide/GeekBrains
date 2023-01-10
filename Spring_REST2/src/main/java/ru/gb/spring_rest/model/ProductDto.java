package ru.gb.spring_rest.model;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;

    private Long article;

    private String title;

    private Double price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.article = product.getArticle();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }
}
