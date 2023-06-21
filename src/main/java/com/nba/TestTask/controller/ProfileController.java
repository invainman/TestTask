package com.nba.TestTask.controller;

import com.nba.TestTask.dto.ProfileDto;
import com.nba.TestTask.entity.Profile;
import com.nba.TestTask.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    final private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<Profile> create(@RequestBody ProfileDto profileDto) {
        return new ResponseEntity<>(profileService.create(profileDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAll() {
        return new ResponseEntity<>(profileService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getById(@PathVariable Long id) {
        return new ResponseEntity<>(profileService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Profile> update(@RequestBody ProfileDto profileDto) {
        return new ResponseEntity<>(profileService.update(profileDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        profileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
