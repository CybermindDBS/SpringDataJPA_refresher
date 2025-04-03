package com.example.springdatajpa.repository.crudrepository;

import com.example.springdatajpa.entity.ProfileMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyCrudRepository2 {
    @Autowired
    MyCrudRepo2 repo;

    public void save(ProfileMedia profileMedia) {
        repo.save(profileMedia);
    }

    public Iterable<ProfileMedia> readAll() {
        return repo.findAll();
    }
}
