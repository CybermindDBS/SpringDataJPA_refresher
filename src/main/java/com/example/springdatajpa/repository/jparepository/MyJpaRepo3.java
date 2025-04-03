package com.example.springdatajpa.repository.jparepository;

import com.example.springdatajpa.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyJpaRepo3 extends JpaRepository<UserProfile, Long> {

    /*
     * <IMPORTANT>
     * Note: This is for reference purpose only, this will not work since H2 DB does not support stored procedures.
     * */

    //Example for calling stored procedures
    @Procedure(name = "UserProfile.getUserByName")
    List<UserProfile> getUserByName(@Param("name") String username);
}
