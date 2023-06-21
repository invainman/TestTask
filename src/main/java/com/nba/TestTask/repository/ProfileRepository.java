package com.nba.TestTask.repository;

import com.nba.TestTask.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile getById(Long id);
}
