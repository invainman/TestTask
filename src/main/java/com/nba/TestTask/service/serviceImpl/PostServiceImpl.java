package com.nba.TestTask.service.serviceImpl;

import com.nba.TestTask.dto.PostDto;
import com.nba.TestTask.entity.Post;
import com.nba.TestTask.entity.Profile;
import com.nba.TestTask.repository.PostRepository;
import com.nba.TestTask.repository.ProfileRepository;
import com.nba.TestTask.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    final private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post create(PostDto postDto) {
        return postRepository.save(Post.builder()
                .profileId(postDto.getProfileId())
                .author(postDto.getAuthor())
                .topic(postDto.getTopic())
                .text(postDto.getText())
                .build());
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getById(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new RuntimeException(String.format("Post with id %s not found", id)));
    }

    @Override
    public Post update(PostDto postDto) {
        Post post = postRepository.findById(postDto.getId()).orElseThrow(() ->
                new RuntimeException(String.format("Post with id %s not found", postDto.getId())));
        post.setAuthor(postDto.getAuthor());
        post.setTopic(postDto.getTopic());
        post.setText(postDto.getText());
        post.setProfileId(postDto.getProfileId());
        return postRepository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
