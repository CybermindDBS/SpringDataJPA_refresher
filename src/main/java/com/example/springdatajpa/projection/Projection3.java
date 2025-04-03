package com.example.springdatajpa.projection;

public class Projection3 {
    static int myCounter;
    Long id;
    String name;
    Long phoneNo;

    Projection3(Long id, String name, Long phoneNo) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        myCounter++;
    }

    @Override
    public String toString() {
        return "Projection3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNo=" + phoneNo +
                ", myCounter=" + myCounter +
                '}';
    }
}
