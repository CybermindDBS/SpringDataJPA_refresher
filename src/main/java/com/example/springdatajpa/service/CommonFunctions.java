package com.example.springdatajpa.service;

import com.example.springdatajpa.repository.crudrepository.MyCrudRepository;
import com.example.springdatajpa.repository.crudrepository.MyCrudRepository2;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonFunctions {
    @Autowired
    Logger logger;
    @Autowired
    MyCrudRepository repo1;
    @Autowired
    MyCrudRepository2 repo2;


    public void insertRecords() {

        //Setup: Inserting records for demo purpose.
        List<List<String>> lists = new ArrayList<>(List.of(
                List.of("Alice", "9876543210"),
                List.of("Bob", "9123456789"),
                List.of("Charlie", "9345678901"),
                List.of("David", "9567890123"),
                List.of("Emma", "9789012345"),
                List.of("Frank", "9988776655"),
                List.of("Grace", "9678901234"),
                List.of("Hannah", "9456789012"),
                List.of("Isaac", "9234567890"),
                List.of("Jack", "9321654789")
        ));

        repo1.saveAll(lists);
    }

    public void findAllRecords() {
        logger.info("Fetching records from user_profile table: ");
        repo1.findAll().forEach((userProfile) -> logger.debug(userProfile.toString()));
        logger.info("Fetching records from profile_media table: ");
        repo2.readAll().forEach((profileMedia) -> logger.debug(profileMedia.toString()));
    }
}
