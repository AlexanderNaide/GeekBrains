package ru.gb.spring_rest.repository.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.spring_rest.model.Product;

public class ProductSpecifications {

    public static Specification<Product> priceGreaterOrEqualsThan(Double minPrice){
        System.out.println("Попали в spec min");
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLessenOrEqualsThan(Double maxPrice){
        System.out.println("Попали в spec max");
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> titleLike(String title){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", title));
    }

    public static Specification<Product> categories(String categories){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("subCategory1"), categories);
    }

}
