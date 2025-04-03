package com.example.springdatajpa.repository.crudrepository;

import com.example.springdatajpa.entity.ProfileMedia;
import com.example.springdatajpa.entity.UserProfile;
import com.example.springdatajpa.utils.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MyCrudRepository {
    @Autowired
    MyCrudRepo repo;


    /*
     * Note:-
     * some other uncovered methods:
     * repo.findById()
     * repo.deleteAllById()
     * repo.deleteById()
     * etc
     * */


    public void save(UserProfile userProfile) {
        repo.save(userProfile);
    }

    // Batch save Operation
    public void saveAll(Iterable<UserProfile> userProfiles) {
        repo.saveAll(userProfiles);
    }

    public Iterable<UserProfile> findAll() {
        return repo.findAll();
    }

    public Iterable<UserProfile> findAllById(Iterable<Long> ids) {
        return repo.findAllById(ids);
    }

    public void update(UserProfile transientUserProfile) {
        if (repo.existsById(transientUserProfile.getId())) {
            Optional<UserProfile> optional = repo.findById(transientUserProfile.getId());
            if (optional.isPresent()) {
                UserProfile persistentUserProfileObject = optional.get();
                //Copying bean information:
                //Use BeanUtils.copyProperties(userProfile, persistentUserProfileObject);
                //Or
                persistentUserProfileObject.setName(transientUserProfile.getName());
                persistentUserProfileObject.setPhoneNo(transientUserProfile.getPhoneNo());
                persistentUserProfileObject.setMemberSince(transientUserProfile.getMemberSince());

                ProfileMedia persistentProfileMediaObject = persistentUserProfileObject.getProfileMedia();
                persistentProfileMediaObject.setProfileImg(transientUserProfile.getProfileMedia().getProfileImg());
                persistentProfileMediaObject.setResume(transientUserProfile.getProfileMedia().getResume());

                repo.save(persistentUserProfileObject);
            }
        }
    }

    public void delete(UserProfile transientUserProfileObj) {
        if (repo.existsById(transientUserProfileObj.getId())) {
            Optional<UserProfile> optional = repo.findById(transientUserProfileObj.getId());
            if (optional.isPresent()) {
                UserProfile persistentUserProfileObject = optional.get();
                repo.delete(persistentUserProfileObject);
            }
        }
    }

    public Long countTotalRecords() {
        return repo.count();
    }


    // Additional Methods:
    // An example input to below method would be, List<List<String>> lists = new ArrayList<>(List.of(List.of("Alice", "9876543210"),List.of("Bob", "9123456789")));
    public void saveAll(List<List<String>> userProfilesList) {
        List<UserProfile> records = new ArrayList<>();

        for (List<String> list : userProfilesList) {
            try {
                UserProfile userProfile = new UserProfile();
                userProfile.setName(list.get(0));
                userProfile.setPhoneNo(Long.parseLong(list.get(1)));
                userProfile.setMemberSince(GeneralUtils.getRandomLocalDateTime());

                ProfileMedia profileMedia = new ProfileMedia();
                profileMedia.setProfileImg(Path.of(getClass().getClassLoader().getResource("sampleMedia/myProfileImg.png").toURI()));
                profileMedia.setResume(Path.of(getClass().getClassLoader().getResource("sampleMedia/myResume2.txt").toURI()));
                profileMedia.setUserProfile(userProfile);

                userProfile.setProfileMedia(profileMedia);

                records.add(userProfile);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        repo.saveAll(records);
    }
}
