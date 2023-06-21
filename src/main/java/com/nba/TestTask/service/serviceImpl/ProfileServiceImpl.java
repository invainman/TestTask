package com.nba.TestTask.service.serviceImpl;

import com.nba.TestTask.dto.ProfileDto;
import com.nba.TestTask.entity.Profile;
import com.nba.TestTask.repository.PostRepository;
import com.nba.TestTask.repository.ProfileRepository;
import com.nba.TestTask.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    private final PostRepository postRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository, PostRepository postRepository) {
        this.profileRepository = profileRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Profile create(ProfileDto profileDto) {
        return profileRepository.save(Profile.builder()
                .email(profileDto.getEmail())
                .name(profileDto.getName())
                .surname(profileDto.getSurname())
                .location(profileDto.getLocation())
                .age(profileDto.getAge())
                .build());
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id).orElseThrow(() ->
                new RuntimeException(String.format("Profile with id %s not found", id)));
    }

    @Override
    public Profile update(ProfileDto profileDto) {
        Profile profile = profileRepository.findById(profileDto.getId()).orElseThrow(() ->
                new RuntimeException(String.format("Profile with id %s not found", profileDto.getId())));
        profile.setEmail(profileDto.getEmail());
        profile.setName(profileDto.getName());
        profile.setSurname(profileDto.getSurname());
        profile.setLocation(profileDto.getLocation());
        profile.setAge(profileDto.getAge());
        return profileRepository.save(profile);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteAllByProfileId(id);
        profileRepository.deleteById(id);
    }
}
