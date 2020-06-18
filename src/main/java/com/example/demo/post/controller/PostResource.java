package com.example.demo.post.controller;


import com.example.demo.post.model.entity.Post;
import com.example.demo.post.model.repository.PostRepository;
import com.example.demo.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PostResource {
    private PostService postService;
    private PostRepository postRepository;

    @Autowired
    public PostResource(PostService postService, PostRepository postRepository) {
        this.postService = postService;
        this.postRepository = postRepository;
    }

    @CrossOrigin
    @GetMapping("/api/posts")
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @CrossOrigin
    @GetMapping("/api/posts/{id}")
    public Post get(@PathVariable int id) {
        return postService.get(id);
    }

    @CrossOrigin
    @PostMapping("/api/posts")
    public ResponseEntity<Void> createPost(@RequestBody Post post) {
        postService.addPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

