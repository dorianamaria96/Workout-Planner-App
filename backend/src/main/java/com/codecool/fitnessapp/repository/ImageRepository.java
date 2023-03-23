package com.codecool.fitnessapp.repository;

import com.codecool.fitnessapp.entity.Image;
import com.codecool.fitnessapp.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    boolean existsByUser(User user);

    Optional<Image> findByUser(User user);
}
