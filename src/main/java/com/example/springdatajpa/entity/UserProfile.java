package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Long phoneNo;
    @NonNull
    private LocalDateTime memberSince;
    @NonNull
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private ProfileMedia profileMedia;
}
