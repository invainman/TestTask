package com.nba.TestTask.service;

import com.nba.TestTask.dto.PostDto;
import com.nba.TestTask.entity.Post;

import java.util.List;

public interface PostService {

    Post create(PostDto postDto);

    List<Post> getAll();

    Post getById(Long id);

    Post update(PostDto postDto);

    void deleteById(Long id);
}
