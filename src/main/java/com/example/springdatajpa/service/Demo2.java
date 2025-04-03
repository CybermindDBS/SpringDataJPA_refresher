package com.example.springdatajpa.service;

import com.example.springdatajpa.repository.pagingandsortingrepository.MyPagingAndSortingRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Demo2 {

    @Autowired
    MyPagingAndSortingRepository pagingAndSortingRepositoryRepo;

    @Autowired
    Logger logger;


    //Demo: For Paging and Sorting of records
    public void run1(int pageNo) {
        pagingAndSortingRepositoryRepo.sortAndDisplayRecordsFromPageNo(pageNo).forEach((userProfile -> logger.debug(userProfile.toString())));
    }
}
