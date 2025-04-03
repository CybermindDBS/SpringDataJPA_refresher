package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Entity
@Data
@NoArgsConstructor
public class ProfileMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    private byte[] profileImg;
    @Lob
    private byte[] resume;
    @OneToOne
    @JoinColumn(name = "id")
    private UserProfile userProfile;

    public ProfileMedia(Path imgPath, Path filePath, UserProfile userProfile) {
        setProfileImg(imgPath);
        setResume(filePath);
        this.userProfile = userProfile;
    }

    public byte[] getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(Path imgPath) {
        try {
            this.profileImg = Files.readAllBytes(imgPath);
        } catch (IOException e) {
            this.profileImg = null;
        }
    }

    public void setProfileImg(byte[] bytes) {
        this.profileImg = bytes;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(Path filePath) {
        try {
            this.resume = Files.readAllBytes(filePath);
        } catch (IOException e) {
            this.resume = null;
        }
    }

    public void setResume(byte[] bytes) {
        this.resume = bytes;
    }

    @Override
    public String toString() {
        return "ProfileMedia{" +
                "id=" + id +
                ", profileImgSize=" + profileImg.length +
                ", resumeSize=" + resume.length +
                ", userProfile=" + userProfile.getId() +
                '}';
    }
}
