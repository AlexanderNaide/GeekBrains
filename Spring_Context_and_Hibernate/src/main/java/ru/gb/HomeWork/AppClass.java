package ru.gb.HomeWork;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.HomeWork.Repository.ProductRepository;
import ru.gb.HomeWork.Repository.TheBuyRepository;
import ru.gb.HomeWork.Repository.UserRepository;

public class AppClass {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.gb.HomeWork");
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        TheBuyRepository buyRepository = context.getBean(TheBuyRepository.class);




        System.out.println("\n\nСписок товаров, купленных пользователем с датой и ценой по id покупателя(id3)");
        buyRepository.method1(3L).forEach(System.out::println);



        System.out.println("\n\nСписок покупок с указанием времени по id покупателя(id2)");
        buyRepository.method2(2L).forEach(System.out::println);



        System.out.println("\n\nСписок пользователей купивших товар с датой и ценой по id товара(id2)");
        buyRepository.method3(2L).forEach(System.out::println);



        System.out.println("\n\nСписок пользователей с потраченной всего суммой сортированной по сумме");
        buyRepository.method4().forEach(System.out::println);

    }
}
