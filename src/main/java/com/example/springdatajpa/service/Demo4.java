package com.example.springdatajpa.service;

import com.example.springdatajpa.projection.Projection1;
import com.example.springdatajpa.projection.Projection2;
import com.example.springdatajpa.projection.Projection3;
import com.example.springdatajpa.repository.jparepository.MyJpaRepo;
import com.example.springdatajpa.repository.jparepository.MyJpaRepo2;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Demo4 {
    @Autowired
    MyJpaRepo repo;
    @Autowired
    MyJpaRepo2 repo2;

    @Autowired
    Logger logger;

    //Demo for @Query methods
    public void run1() {

        //Demo: Native Query
        logger.info("\n-----> Demo: Native Query <-----");
        logger.debug(repo.findRecordBy("Charlie").toString());
        logger.info("x----- xxxxx -----x\n");

        //Demo: Native Query with dynamic projection
        logger.info("\n-----> Demo: Native Query with dynamic projection <-----");
        logger.debug(repo.findRecordBy("Charlie", Projection1.class).toStringValue());
        logger.info("x----- xxxxx -----x\n");


        //Demo: JPQL
        logger.info("\n-----> Demo: JPQL <-----");
        logger.debug(repo.findRecordBy("Charlie").toString());
        logger.info("x----- xxxxx -----x\n");

        //Demo: JPQL with dynamic projection(for class DTO projection)
        logger.info("\n-----> Demo: JPQL with dynamic projection(for class DTO projection) <-----");
        repo.findRecordsByNameContaining("a", Projection1.class).forEach((projection -> logger.debug(projection.toStringValue())));
        logger.info("x----- xxxxx -----x\n");

        //Demo: JPQL with static projection(for interface projection)
        logger.info("\n-----> Demo: JPQL with static projection(for interface projection) <-----");
        repo.findRecordsByNameContaining2("a").forEach((projection -> logger.debug(projection.toString())));
        logger.info("x----- xxxxx -----x\n");
    }

    public void run2()
    {
        //Demo: @Query method with @Modifying annotation, Updating name & memberSince field for Id = 1
        logger.info("\n-----> Demo: @Query method with @Modifying annotation Updating name & memberSince field for Id = 1 <-----");
        logger.debug("Updated name, records affected: " + repo2.updateNameById(1L, "ChangedName"));
        logger.debug("Updated member_since, records affected: " + repo2.updateMemberSinceById(1L, LocalDateTime.now()));
        logger.debug("Fetching record with Id = 1: " + repo2.findById(1L).get());
        logger.info("x----- xxxxx -----x\n");
    }
}
