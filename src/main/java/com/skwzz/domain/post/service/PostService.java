package com.skwzz.domain.post.service;

import com.skwzz.domain.post.dto.CreatePostDto;
import com.skwzz.domain.post.dto.ReadPostDto;
import com.skwzz.domain.post.dto.UpdatePostDto;
import com.skwzz.domain.post.entity.Post;
import com.skwzz.domain.post.mapper.PostMapper;
import com.skwzz.domain.post.repository.PostRepository;
import com.skwzz.global.constants.ErrorMessage;
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
        Post post = postRepository.findById(postId).orElseThrow(() -> new NoSuchElementException(ErrorMessage.NOT_FOUND_POST));
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
    public ReadPostDto updatePost(Long postId, UpdatePostDto updatePostDto) throws Exception {
        if(!postId.equals(updatePostDto.getId())) throw new Exception();
        Post post = postRepository.findById(postId).orElseThrow(() -> new NoSuchElementException(ErrorMessage.NOT_FOUND_POST));
        post.changePostInfo(updatePostDto);
        return PostMapper.toDto(post);
    }

    @Transactional
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

}
