package ru.gb.spring_rest.repository.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.spring_rest.model.Product;

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

    public static Specification<Product> priceGreaterOrEqualsThanCom(Double minPrice){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLessenOrEqualsThanCom(Double minPrice){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> titleLikeCom(String title){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", title));
    }

}
