package com.skwzz.domain.post.service;

import com.skwzz.domain.post.dto.CreatePostDto;
import com.skwzz.domain.post.dto.ReadPostDto;
import com.skwzz.domain.post.entity.Post;
import com.skwzz.domain.post.mapper.PostMapper;
import com.skwzz.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<ReadPostDto> readAllPost() {
        List<Post> postList = postRepository.findAll();
        return PostMapper.toDtoList(postList);
    }

    public ReadPostDto readPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new NoSuchElementException());
        return PostMapper.toDto(post);
    }

    @Transactional
    public ReadPostDto createPost(CreatePostDto createPostDto) {
        Post newPost = Post.builder()
                .title(createPostDto.getTitle())
                .contents(createPostDto.getContents())
                .build();
        postRepository.save(newPost);
        return PostMapper.toDto(newPost);
    }

    @Transactional
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
