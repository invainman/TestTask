package com.nba.TestTask.service;

import com.nba.TestTask.dto.ProfileDto;
import com.nba.TestTask.entity.Profile;

import java.util.List;

public interface ProfileService {

    Profile create(ProfileDto profileDto);

    List<Profile> getAll();

    Profile getById(Long id);

    Profile update(ProfileDto profileDto);

    void deleteById(Long id);
}
