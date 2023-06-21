package com.nba.TestTask.dto;

import lombok.Data;

@Data
public class PostDto {

    private Long id;

    private String author;

    private String topic;

    private String text;

    private Long profileId;
}
