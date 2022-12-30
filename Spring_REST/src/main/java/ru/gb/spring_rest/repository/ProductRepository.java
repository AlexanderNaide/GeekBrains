package ru.gb.spring_rest.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.spring_rest.model.Product;
import ru.gb.spring_rest.model.ProductCom;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

//    Optional<Product> findByTitle(String title);


//    @Transactional
//    @Modifying
//    @Query("select p from Product p where p.id < 100")
//    List<Product> findAllCompress();

//    @Modifying
//    @Query("select new ru.gb.spring_rest.model.ProductCom(p.id, p.title, p.price) from Product p where p.id < 100")
//    Page<ProductCom> findAllCom(Specification<ProductCom> spec, PageRequest of);

//    @Modifying
//    @Query("select new ru.gb.spring_rest.model.ProductCom(p.id, p.title, p.price) from Product p where p.id < 100")
//    Page<ProductCom> findCom(Specification<ProductCom> spec, PageRequest of);

//    @Modifying
//    @Query("select new ru.gb.spring_rest.model.ProductCom(p.id, p.title, p.price) from Product p where p.id < 100")
//    Page<Product> findCom(Specification<Product> spec, PageRequest of);

//    @Modifying
    @Query("select new ru.gb.spring_rest.model.ProductCom(p.id, p.title, p.price) from Product p")
    Page<Product> findCom(Specification<Product> spec, PageRequest of);

}
