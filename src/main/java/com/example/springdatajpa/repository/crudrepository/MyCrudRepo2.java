package com.example.springdatajpa.repository.crudrepository;

import com.example.springdatajpa.entity.ProfileMedia;
import org.springframework.data.repository.CrudRepository;

public interface MyCrudRepo2 extends CrudRepository<ProfileMedia, Long> {
}
