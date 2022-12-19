package ru.gb.HomeWork;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.HomeWork.Repository.ProductRepository;
import ru.gb.HomeWork.Repository.UserRepository;
import ru.gb.HomeWork.model.Product;
import ru.gb.HomeWork.model.User;

import java.util.List;

public class AppClass {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.gb.HomeWork");
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        UserRepository userRepository = context.getBean(UserRepository.class);

        productRepository.insert(new Product("Молоко", 65.60));
        productRepository.insert(new Product("Кефир", 75.80));
        productRepository.insert(new Product("Йогурт", 88.90));
        productRepository.insert(new Product("Хлеб", 49.9));
        productRepository.insert(new Product("Батон", 55.6));
        productRepository.insert(new Product("Огурцы", 244.9));
        productRepository.insert(new Product("Помидоры", 180.0));
        productRepository.insert(new Product("Бананы", 139.99));

        userRepository.insert(new User("user1"));
        userRepository.insert(new User("user2"));
        userRepository.insert(new User("user3"));
        userRepository.insert(new User("user4"));
        userRepository.insert(new User("user5"));
        userRepository.insert(new User("user6"));
        userRepository.insert(new User("user7"));
        userRepository.insert(new User("user8"));
        userRepository.insert(new User("user9"));
        userRepository.insert(new User("user10"));

//        userRepository.addProduct(8L, 8L);
//        userRepository.addProduct(8L, 4L);
//        userRepository.addProduct(10L, 6L);
//        userRepository.addProduct(4L, 4L);
//        userRepository.addProduct(1L, 2L);
//        userRepository.addProduct(7L, 7L);
//        userRepository.addProduct(9L, 5L);
//        userRepository.addProduct(2L, 3L);
//        userRepository.addProduct(7L, 1L);
//        userRepository.addProduct(3L, 7L);
//        userRepository.addProduct(7L, 2L);
//        userRepository.addProduct(2L, 4L);
//        userRepository.addProduct(4L, 8L);
//        userRepository.addProduct(10L, 8L);
//        userRepository.addProduct(1L, 4L);
//        userRepository.addProduct(9L, 2L);
//        userRepository.addProduct(7L, 1L);
//        userRepository.addProduct(2L, 5L);
//        userRepository.addProduct(4L, 3L);
//        userRepository.addProduct(10L, 7L);
//        userRepository.addProduct(1L, 4L);
//        userRepository.addProduct(3L, 2L);
//        userRepository.addProduct(7L, 6L);
//        userRepository.addProduct(5L, 7L);
//        userRepository.addProduct(7L, 3L);






        // Получаем и печатаем список продуктов у покупателя
//        userRepository.get(7L).getProducts().forEach(System.out::println); // старый вариант
        userRepository.get(7L).getBuyList().forEach(b -> b.getProductsList().forEach(System.out::println));

        // Получаем и печатаем список покупателей на товар
        productRepository.get(7L).getUsers().forEach(System.out::println);


    }
}
