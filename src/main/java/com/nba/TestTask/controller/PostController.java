package com.nba.TestTask.controller;

import com.nba.TestTask.dto.PostDto;
import com.nba.TestTask.entity.Post;
import com.nba.TestTask.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    final private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.create(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAll() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Post> update(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.update(postDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
