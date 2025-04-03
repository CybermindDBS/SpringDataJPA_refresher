package com.example.springdatajpa.repository.jparepository;

import com.example.springdatajpa.entity.UserProfile;
import com.example.springdatajpa.projection.Projection3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyJpaRepo extends JpaRepository<UserProfile, Long> {

    // Native Query
    @Query(value = "select * from user_profile where name = :name;", nativeQuery = true)
    UserProfile findRecordBy(@Param("name") String userName);

    // Native Query with dynamic projection
    @Query(value = "select * from user_profile where name = :name;", nativeQuery = true)
    <T> T findRecordBy(String name, Class<T> projection);



    //JPQL
    @Query("select u from UserProfile u where u.name like %?1%")
    UserProfile findRecordsByNameContaining(String pattern);

    //JPQL with dynamic projection(for class type projection)
    @Query("select u.name as name, u.phoneNo as phoneNo from UserProfile u where u.name like %?1%")
    <T >List<T> findRecordsByNameContaining(String pattern, Class<T> projection);

    //JPQL with static projection(for interface type projection)
    @Query("select new com.example.springdatajpa.projection.Projection3(u.id, u.name, u.phoneNo) from UserProfile u where u.name like %?1%")
    List<Projection3> findRecordsByNameContaining2(String pattern);
}
