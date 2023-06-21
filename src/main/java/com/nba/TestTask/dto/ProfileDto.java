package com.nba.TestTask.dto;

import lombok.Data;

@Data
public class ProfileDto {

    private Long id;

    private String email;

    private String name;

    private String surname;

    private String location;

    private int age;
}
