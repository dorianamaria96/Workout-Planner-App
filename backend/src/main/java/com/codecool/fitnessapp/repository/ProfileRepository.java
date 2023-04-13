package com.codecool.fitnessapp.repository;

import com.codecool.fitnessapp.entity.Profile;
import com.codecool.fitnessapp.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile findProfileByUser(User user);
}
