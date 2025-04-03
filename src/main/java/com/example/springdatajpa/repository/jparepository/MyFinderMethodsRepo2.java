package com.example.springdatajpa.repository.jparepository;

import com.example.springdatajpa.entity.UserProfile;
import com.example.springdatajpa.projection.Projection1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyFinderMethodsRepo2 extends JpaRepository<UserProfile, Long> {

    //Static projection
    Projection1 findByPhoneNo(Long phoneNo);

    //Dynamic projection
    <T> List<T> findAllByNameContaining(String pattern, Class<T> projection);
}
