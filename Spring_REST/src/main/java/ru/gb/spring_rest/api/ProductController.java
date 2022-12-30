package ru.gb.spring_rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.spring_rest.model.Product;
import ru.gb.spring_rest.model.ProductCom;
import ru.gb.spring_rest.services.ProductService;


import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable Long id){
//        return productService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }

//    @GetMapping
//    public List<Product> getAll(){
//        return productService.findAllCompressed();
//    }

    @PostMapping
    public Page<Product> upAll(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false) String val,
                               @RequestParam(required = false) Double min,
                               @RequestParam(required = false) Double max){
        if(page < 1){
            page = 1;
        }


        return productService.findCom(min, max, val, page);
    }

    @GetMapping
    public Page<Product> findAll(){
        Page<Product> page = productService.findCom(null, null, null, 1);
        page.stream().forEach(product -> System.out.println(product.getTitle()));
        return page;
    }


//    @PostMapping("/add")
//    public void addProduct(@RequestBody Product product){
//        productService.addProd(product);
//    }

/*    @DeleteMapping("/delete")
    public void deleteById(@RequestParam Long id){
        productService.deleteById(id);
    }*/
}
