package com.example.springdatajpa.service;

import com.example.springdatajpa.entity.ProfileMedia;
import com.example.springdatajpa.entity.UserProfile;
import com.example.springdatajpa.repository.crudrepository.MyCrudRepository;
import com.example.springdatajpa.repository.crudrepository.MyCrudRepository2;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.LocalDateTime;

@Service
public class Demo1 {
    @Autowired
    Logger logger;
    @Autowired
    MyCrudRepository repo1;
    @Autowired
    MyCrudRepository2 repo2;

    //Demo: For Saving records
    public void run1() {
        UserProfile userProfile = new UserProfile();
        userProfile.setName("SomeName");
        userProfile.setPhoneNo(1234567890L);
        userProfile.setMemberSince(LocalDateTime.now());
        ProfileMedia profileMedia = new ProfileMedia();
        try {
            profileMedia.setResume(Path.of(getClass().getClassLoader().getResource("sampleMedia/myResume.txt").toURI()));
            profileMedia.setProfileImg(Path.of(getClass().getClassLoader().getResource("sampleMedia/myProfileImg.png").toURI()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        profileMedia.setUserProfile(userProfile);
        userProfile.setProfileMedia(profileMedia);
        repo1.save(userProfile);
    }

    //Demo: For Fetching records
    public void run2() {
        logger.info("Fetching records from user_profile table: ");
        repo1.findAll().forEach((userProfile) -> logger.debug(userProfile.toString()));
        logger.info("Fetching records from profile_media table: ");
        repo2.readAll().forEach((profileMedia) -> logger.debug(profileMedia.toString()));
    }

    //Demo: For Updating records
    public void run3() {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(1L);
        userProfile.setName("ChangedName");
        userProfile.setPhoneNo(1299999990L);
        userProfile.setMemberSince(LocalDateTime.now());
        ProfileMedia profileMedia = new ProfileMedia();
        // profileMedia.setId(1L); this line is required if we are using BeanUtils to copy bean properties in MyCrudRepository.update().
        try {
            profileMedia.setResume(Path.of(getClass().getClassLoader().getResource("sampleMedia/myResume2.txt").toURI()));
            profileMedia.setProfileImg(Path.of(getClass().getClassLoader().getResource("sampleMedia/myProfileImg.png").toURI()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        profileMedia.setUserProfile(userProfile);
        userProfile.setProfileMedia(profileMedia);
        repo1.update(userProfile);
    }

    //Demo: For deleting
    public void run4() {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(1L);
        repo1.delete(userProfile);
    }

    //Demo: For Counting total amounts of records
    public void run5() {
        logger.debug("Total no. of records present: " + repo1.countTotalRecords());
    }
}
