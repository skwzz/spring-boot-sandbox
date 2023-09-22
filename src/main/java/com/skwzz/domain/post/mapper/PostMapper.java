package com.skwzz.domain.post.mapper;

import com.skwzz.domain.post.dto.CreatePostDto;
import com.skwzz.domain.post.dto.ReadPostDto;
import com.skwzz.domain.post.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static Post toEntity(CreatePostDto createPostDto){
        return Post.builder()
                .title(createPostDto.getTitle())
                .contents(createPostDto.getContents())
                .build();
    }

    public static ReadPostDto toDto(Post post){
        return ReadPostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .contents(post.getContents())
                .build();
    }

    public static List<ReadPostDto> toDtoList(List<Post> postList){
        return postList.stream()
                .map(PostMapper::toDto)
                .collect(Collectors.toList());
    }
}
