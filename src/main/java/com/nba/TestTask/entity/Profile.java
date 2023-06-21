package com.nba.TestTask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_id_seq")
    private Long id;

    private String email;

    private String name;

    private String surname;

    private String location;

    private int age;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profileId")
    private List<Post> posts;
}
