package com.example.springdatajpa.repository.pagingandsortingrepository;

import com.example.springdatajpa.entity.UserProfile;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MyPagingAndSortingRepo extends PagingAndSortingRepository<UserProfile, Long> {
}
