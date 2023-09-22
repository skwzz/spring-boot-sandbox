package com.skwzz.domain.post.controller;

import com.skwzz.domain.post.dto.CreatePostDto;
import com.skwzz.domain.post.dto.ReadPostDto;
import com.skwzz.domain.post.entity.Post;
import com.skwzz.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<ReadPostDto> readAllPost(){
        return postService.readAllPost();
    }

    @GetMapping("/{postId}")
    public ReadPostDto readPost(@PathVariable Long postId){
        return postService.readPost(postId);
    }

    @PostMapping
    public ReadPostDto createPost(@RequestBody CreatePostDto createPostDto){
        return postService.createPost(createPostDto);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }
}
