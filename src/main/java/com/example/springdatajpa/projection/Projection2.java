package com.example.springdatajpa.projection;

import java.time.LocalDateTime;

public interface Projection2 {
    Long getId();

    LocalDateTime getMemberSince();

    default String toStringValue() {
        return "Projection2 [id=" + getId() + ", memberSince=" + getMemberSince() + "]";
    }

}
