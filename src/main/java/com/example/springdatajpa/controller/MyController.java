package com.example.springdatajpa.controller;

import com.example.springdatajpa.service.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MyController {

    @Autowired
    Logger logger;
    @Autowired
    CommonFunctions commonFunctions;
    @Autowired
    Demo1 demo1;
    @Autowired
    Demo2 demo2;
    @Autowired
    Demo3 demo3;
    @Autowired
    Demo4 demo4;

    public void crudRepositoryDemo() {

        //<----- Demo: CrudRepository ----->
        // Save operation
        logger.info("\nDemo: CrudRepository");
        logger.info("Demo operations flow: save -> find -> update -> find -> count -> delete -> count");
        logger.info("Currently there are no records in both tables (user_profile & profile_media)");
        logger.info("\n-----> Performing Save operation <-----");
        demo1.run1();
        logger.info("x----- xxxxx -----x\n");

        // Find operation
        logger.info("\n-----> Performing Find all operation after Save operation <-----");
        demo1.run2();
        logger.info("x----- xxxxx -----x\n");

        // Update operation
        logger.info("\n-----> Performing Update operation <-----");
        demo1.run3();
        logger.info("x----- xxxxx -----x\n");

        logger.info("\n-----> Performing Find all operation after Update operation <-----");
        demo1.run2();
        logger.info("x----- xxxxx -----x\n");

        //Counting total records
        logger.info("\n-----> Performing Count operation <-----");
        demo1.run5();
        logger.info("x----- xxxxx -----x\n");

        //Delete operation
        logger.info("\n-----> Performing Delete operation <-----");
        demo1.run4();
        logger.info("x----- xxxxx -----x\n");

        logger.info("\n-----> Performing Count operation after Delete operation <-----");
        demo1.run5();
        logger.info("x----- xxxxx -----x\n");
    }

    public void pagingAndSortingRepositoryDemo() {

        logger.info("\n-----> Inserting 10 sample records for demo purpose <-----");
        commonFunctions.insertRecords();
        logger.info("x----- xxxxx -----x\n");

        logger.info("\nDemo: PagingAndSortingRepository");
        logger.info("Demo operations flow: show all records -> paging and sorting of records");
        logger.info("Note:");
        logger.info("1. Max records in a page is set to 4.");
        logger.info("2. Total no. of records in db is 10.");
        logger.info("3. Records will be sorted on basis of memberSince & name fields");
        Scanner sc2 = new Scanner(System.in);
        logger.info("\nEnter the page number to view the records: ");
        int pageNo = sc2.nextInt();

        logger.info("\n-----> Performing Find all operation <-----");
        demo1.run2();
        logger.info("x----- xxxxx -----x\n");

        logger.info("\n-----> Performing Paging & Sorting of Records in user_profile table, currently displaying records from pageNo = " + pageNo + " <-----");
        demo2.run1(pageNo);
        logger.info("x----- xxxxx -----x\n");
    }

    public void jpaRepositoryDemo() {
        logger.info("\n-----> Inserting 10 sample records for demo purpose <-----");
        commonFunctions.insertRecords();
        logger.info("x----- xxxxx -----x\n");

        logger.info("\nDemo: JpaRepository");
        logger.info("Subcategories: ");
        logger.info("1. Finder methods");
        logger.info("2. Finder methods with static & dynamic projections");
        logger.info("3. @Query methods with projections");
        logger.info("4. @Query methods with @Modifying");
        logger.info("\nEnter the category to view outputs for: ");
        Scanner sc2 = new Scanner(System.in);
        int choice = sc2.nextInt();
        switch (choice) {
            case 1 -> demo3.run1();
            case 2 -> demo3.run2();
            case 3 -> demo4.run1();
            case 4 -> demo4.run2();
        }
    }
}
