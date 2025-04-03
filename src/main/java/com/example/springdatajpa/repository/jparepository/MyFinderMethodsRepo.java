package com.example.springdatajpa.repository.jparepository;

import com.example.springdatajpa.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyFinderMethodsRepo extends JpaRepository<UserProfile, Long> {

    /*
     * Note: Finder methods supports read operations only.
     * */

    //Read Operations
    UserProfile findByPhoneNo(Long phoneNo);

    List<UserProfile> findByPhoneNoOrName(Long phoneNo, String name);

    List<UserProfile> findByIdBetween(Long start, Long end);

    List<UserProfile> findByNameContaining(String pattern);
}
