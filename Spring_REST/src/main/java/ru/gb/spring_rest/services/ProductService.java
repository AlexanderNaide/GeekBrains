package ru.gb.spring_rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.spring_rest.model.Product;
import ru.gb.spring_rest.model.ProductCom;
import ru.gb.spring_rest.repository.ProductRepository;
import ru.gb.spring_rest.repository.specifications.ProductSpecifications;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setCategoryRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public Optional<Product> findProdByName(String title){
//        return productRepository.findByTitle(title);
//    }

//    public void addProd(Product product){
//        productRepository.save(product);
//    }

//    public Optional<Product> findById(Long id) {
//        return productRepository.findById(id);
//    }

//    public List<Product> findAll() {
//        return productRepository.findAll();
//    }

//    public Page<Product> findCom() {
//        return productRepository.findCom();
//    }

//    public Page<Product> find(Double minPrice, Double maxPrice, String title, Integer page){
//        Specification<Product> spec = Specification.where(null);
//        if(minPrice != null){
//            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(minPrice));
//        }
//        if(maxPrice != null){
//            spec = spec.and(ProductSpecifications.priceLessenOrEqualsThan(maxPrice));
//        }
//        if(title != null){
//            spec = spec.and(ProductSpecifications.titleLike(title));
//        }
////        return productRepository.findAll(spec, PageRequest.of(page - 1, 10, Sort.by(title)));
//        return productRepository.findAll(spec, PageRequest.of(page - 1, 10));
//    }




    public Page<Product> findCom(Double minPrice, Double maxPrice, String title, Integer page){
        Specification<Product> spec = Specification.where(null);
        if(minPrice != null){
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThanCom(minPrice));
        }
        if(maxPrice != null){
            spec = spec.and(ProductSpecifications.priceLessenOrEqualsThanCom(maxPrice));
        }
        if(title != null){
            spec = spec.and(ProductSpecifications.titleLikeCom(title));
        }
//        return productRepository.findAll(spec, PageRequest.of(page - 1, 10, Sort.by(title)));
        return productRepository.findCom(spec, PageRequest.of(page - 1, 10));
    }

}
