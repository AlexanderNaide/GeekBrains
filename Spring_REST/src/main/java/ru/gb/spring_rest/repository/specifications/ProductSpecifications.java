package ru.gb.spring_rest.repository.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.spring_rest.model.Product;
import ru.gb.spring_rest.model.ProductCom;

public class ProductSpecifications {

    public static Specification<Product> priceGreaterOrEqualsThan(Double minPrice){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLessenOrEqualsThan(Double minPrice){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> titleLike(String title){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", title));
    }

    public static Specification<ProductCom> priceGreaterOrEqualsThanCom(Double minPrice){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<ProductCom> priceLessenOrEqualsThanCom(Double minPrice){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<ProductCom> titleLikeCom(String title){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", title));
    }

}
