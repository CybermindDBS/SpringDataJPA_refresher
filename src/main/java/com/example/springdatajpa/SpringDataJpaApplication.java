package com.example.springdatajpa;

import com.example.springdatajpa.controller.MyController;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
        Logger logger = (Logger) context.getBean("logger");

        MyController controller = context.getBean(MyController.class);

        logger.info("Spring Data JPA - Sample Spring Boot Project");
        logger.info("\nDemos:-");
        logger.debug("1. CrudRepository");
        logger.debug("2. PagingAndSortingRepository");
        logger.debug("3. JpaRepository");
        logger.info("\nEnter option no. to view execution output: ");

        Scanner sc = new Scanner(System.in);
        String choice = sc.next();

        switch (choice) {
            case "1" -> {
                //Demo: CrudRepository
                controller.crudRepositoryDemo();
            }

            case "2" -> {
                //Demo: PagingAndSortingRepository
                controller.pagingAndSortingRepositoryDemo();
            }

            case "3" -> {
                //Demo: JpaRepository
                controller.jpaRepositoryDemo();
            }
        }
    }

}
