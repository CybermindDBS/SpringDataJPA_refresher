package com.example.springdatajpa.repository.pagingandsortingrepository;

import com.example.springdatajpa.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class MyPagingAndSortingRepository {

    @Autowired
    MyPagingAndSortingRepo repo;

    /*
     * Note:-
     * Some other uncovered methods:-
     * findAll(Sort)
     * */

    public Iterable<UserProfile> sortAndDisplayRecordsFromPageNo(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 4, Sort.by(Sort.Direction.ASC, "memberSince", "name"));
        return repo.findAll(pageable);
    }
}
