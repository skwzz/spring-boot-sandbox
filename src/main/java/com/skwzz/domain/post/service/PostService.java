package com.skwzz.domain.post.service;

import com.skwzz.domain.post.dto.CreatePostDto;
import com.skwzz.domain.post.entity.Post;
import com.skwzz.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<Post> readAllPost() {
        return postRepository.findAll();
    }

    public Post readPost(Long postId) {
        Optional<Post> maybePost = postRepository.findById(postId);
        if(maybePost.isPresent()){
            return maybePost.get();
        }
        return null;
    }

    @Transactional
    public Post createPost(CreatePostDto createPostDto) {
        Post newPost = Post.builder()
                .title(createPostDto.getTitle())
                .contents(createPostDto.getContents())
                .build();
        return postRepository.save(newPost);
    }

    @Transactional
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
