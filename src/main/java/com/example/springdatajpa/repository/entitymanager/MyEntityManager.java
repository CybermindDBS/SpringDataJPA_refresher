package com.example.springdatajpa.repository.entitymanager;

import com.example.springdatajpa.entity.UserProfile;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
* <IMPORTANT>
* Note: This class is for reference purpose only, this will not work since H2 DB does not support stored procedures.
* */

@Repository
public class MyEntityManager {
    @Autowired
    EntityManager entityManager;

    //Calling stored procedure with EntityManager
    @Transactional
    public int countUsersByStatus(String status) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("count_users_by_status");
        query.registerStoredProcedureParameter("user_status", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("user_count", Integer.class, ParameterMode.OUT);

        query.setParameter("user_status", status);
        query.execute();

        return (Integer) query.getOutputParameterValue("user_count");
    }
}
