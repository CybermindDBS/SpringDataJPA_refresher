package com.example.springdatajpa.projection;

public interface Projection1 {
    String getName();

    Long getPhoneNo();

    default String toStringValue() {
        return "Projection1 [name=" + getName() + ", phoneNo=" + getPhoneNo() + "]";
    }
}
