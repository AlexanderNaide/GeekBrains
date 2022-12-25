package ru.gb.HomeWork;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.HomeWork.Repository.ProductRepository;
import ru.gb.HomeWork.Repository.TheBuyRepository;
import ru.gb.HomeWork.Repository.UserRepository;
import ru.gb.HomeWork.model.Product;

public class AppClass {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.gb.HomeWork");
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        TheBuyRepository buyRepository = context.getBean(TheBuyRepository.class);


        Product p = productRepository.get(2L);
        System.out.println(p.getTitle());
        p.getUsers().forEach(System.out::println);



        System.out.println("\n\nСписок купленных товаров пользователем по id(id3)");
        buyRepository.method1(3L).forEach(System.out::println);



        System.out.println("\n\nСписок покупок пользователя(id2)");
        buyRepository.method2(2L).forEach(System.out::println);



        System.out.println("\n\nСписок пользователей купивших товар по id товара(id2)");
        buyRepository.method3(2L).forEach(System.out::println);



        System.out.println("\n\nПокупательский рейтинг пользователей с суммой потраченных средств в порядке убывания");
        buyRepository.method4().forEach(System.out::println);

    }
}
