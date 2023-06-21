package com.nba.TestTask.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_seq")
    private Long id;

    private String author;

    private String topic;

    private String text;

    private Long profileId;
}