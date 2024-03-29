package com.codecool.fitnessapp.entity;

import com.codecool.fitnessapp.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;
    @OneToOne
    User user;

    public Image(String fileName, String fileType, byte[] data, User user) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.user = user;
    }
}
