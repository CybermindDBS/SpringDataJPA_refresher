package com.example.springdatajpa.repository.crudrepository;

import com.example.springdatajpa.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface MyCrudRepo extends CrudRepository<UserProfile, Long> {
}
