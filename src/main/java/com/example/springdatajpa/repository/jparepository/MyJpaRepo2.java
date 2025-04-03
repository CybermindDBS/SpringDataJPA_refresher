package com.example.springdatajpa.repository.jparepository;

import com.example.springdatajpa.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface MyJpaRepo2 extends JpaRepository<UserProfile, Long> {
    @Transactional
    @Modifying //@Modifying is used for insert, update, delete operations
    @Query(value = "update user_profile set name = :name where id = :id", nativeQuery = true)
    int updateNameById(Long id, String name);

    @Transactional
    @Modifying //@Modifying is used for insert, update, delete operations
    @Query(value = "update user_profile set member_since = :memberSince where id = :id", nativeQuery = true)
    int updateMemberSinceById(Long id, LocalDateTime memberSince);
}

