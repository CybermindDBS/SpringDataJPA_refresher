package com.example.springdatajpa.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.ThreadLocalRandom;

public class GeneralUtils {
    public static LocalDateTime getRandomLocalDateTime() {

        LocalDateTime start = LocalDateTime.now().minusYears(5);
        LocalDateTime end = LocalDateTime.now();

        long startEpoch = start.toEpochSecond(ZoneOffset.UTC);
        long endEpoch = end.toEpochSecond(ZoneOffset.UTC);
        return LocalDateTime.ofEpochSecond(ThreadLocalRandom.current().nextLong(startEpoch, endEpoch), 0, ZoneOffset.UTC);
    }
}

