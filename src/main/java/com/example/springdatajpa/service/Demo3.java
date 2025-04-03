package com.example.springdatajpa.service;

import com.example.springdatajpa.projection.Projection1;
import com.example.springdatajpa.projection.Projection2;
import com.example.springdatajpa.projection.Projection3;
import com.example.springdatajpa.repository.jparepository.MyFinderMethodsRepo;
import com.example.springdatajpa.repository.jparepository.MyFinderMethodsRepo2;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Demo3 {

    @Autowired
    MyFinderMethodsRepo repo;
    @Autowired
    MyFinderMethodsRepo2 repo2;

    @Autowired
    Logger logger;

    // Demo for finder methods
    public void run1() {
        logger.info("\n-----> findByPhoneNo(9678901234L) <-----");
        logger.debug(repo.findByPhoneNo(9678901234L).toString());
        logger.info("x----- xxxxx -----x\n");

        logger.info("\n-----> findByPhoneNoOrName(9678901234L, \"David\") <-----");
        repo.findByPhoneNoOrName(9678901234L, "David").forEach((userProfile -> logger.debug(userProfile.toString())));
        logger.info("x----- xxxxx -----x\n");

        logger.info("\n-----> findByNameContaining(\"a\") <-----");
        repo.findByNameContaining("a").forEach((userProfile -> logger.debug(userProfile.toString())));
        logger.info("x----- xxxxx -----x\n");

        logger.info("\n-----> findByIdBetween(3L, 7L) <-----");
        repo.findByIdBetween(3L, 7L).forEach((userProfile -> logger.debug(userProfile.toString())));
        logger.info("x----- xxxxx -----x\n");
    }

    // Demo for finder methods with static and dynamic projections
    public void run2() {
        logger.info("\n-----> Demo for Static Projection <-----");
        Projection1 projection1 = repo2.findByPhoneNo(9345678901L);
        logger.debug(projection1.toStringValue());
        logger.info("x----- xxxxx -----x\n");

        logger.info("\n-----> Demo for Dynamic Projection <-----");
        repo2.findAllByNameContaining("a", Projection2.class).forEach((projection -> logger.debug(projection.toStringValue())));
        logger.info("x----- xxxxx -----x\n");

        logger.info("\n-----> Demo for Dynamic Projection 2 <-----");
        repo2.findAllByNameContaining("a", Projection3.class).forEach((projection -> logger.debug(projection.toString())));
        logger.info("x----- xxxxx -----x\n");
    }
}
