package ru.gb.spring_boot_and_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring_boot_and_hibernate.model.Product;
import ru.gb.spring_boot_and_hibernate.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> findAllSorted(Double min, Double max) {
        if (max == -1.0){
            return productRepository.findProductsByPriceGreaterThan(min);
        } else {
            return productRepository.findProductsByPriceGreaterThanAndPriceLessThan(min, max);
        }
    }
}
