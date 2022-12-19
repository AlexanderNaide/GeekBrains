package ru.gb.HomeWork;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.HomeWork.Repository.ProductRepository;
import ru.gb.HomeWork.Repository.TheBuyRepository;
import ru.gb.HomeWork.Repository.UserRepository;
import ru.gb.HomeWork.model.Product;
import ru.gb.HomeWork.model.TheBuy;
import ru.gb.HomeWork.model.User;

import java.util.ArrayList;
import java.util.List;

public class AppClass {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.gb.HomeWork");
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        TheBuyRepository buyRepository = context.getBean(TheBuyRepository.class);

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

        List<Product> list1 = new ArrayList<>();
        list1.add(productRepository.get(1L));
        list1.add(productRepository.get(2L));
        list1.add(productRepository.get(4L));
        list1.add(productRepository.get(5L));
        buyRepository.insert(new TheBuy(userRepository.get(1L), list1));

        List<Product> list2 = new ArrayList<>();
        list2.add(productRepository.get(3L));
        list2.add(productRepository.get(5L));
        list2.add(productRepository.get(7L));
        buyRepository.insert(new TheBuy(userRepository.get(2L), list2));

        List<Product> list3 = new ArrayList<>();
        list3.add(productRepository.get(3L));
        list3.add(productRepository.get(5L));
        list3.add(productRepository.get(8L));
        list3.add(productRepository.get(4L));
        list3.add(productRepository.get(2L));
        buyRepository.insert(new TheBuy(userRepository.get(7L), list3));

        List<Product> list4 = new ArrayList<>();
        list4.add(productRepository.get(1L));
        list4.add(productRepository.get(2L));
        list4.add(productRepository.get(4L));
        buyRepository.insert(new TheBuy(userRepository.get(1L), list4));

        List<Product> list5 = new ArrayList<>();
        list5.add(productRepository.get(1L));
        list5.add(productRepository.get(2L));
        list5.add(productRepository.get(4L));
        buyRepository.insert(new TheBuy(userRepository.get(2L), list5));





        // Список товаров, купленных пользователем с датой и ценой по id покупателя
        buyRepository.method1(7L).forEach(System.out::println);


        // Список покупок с указанием времени по id покупателя

        // Список пользователей купивших товар с датой и ценой по id товара

        // Список пользователей с потраченной всего суммой сортированной по сумме


    }
}
