package com.skwzz.domain.post.entity;

import com.skwzz.domain.post.dto.UpdatePostDto;
import com.skwzz.global.model.BaseEntity;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;

    @Builder
    public Post(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void changePostInfo(UpdatePostDto updatePostDto) {
        if(updatePostDto.getTitle() != null && !updatePostDto.getTitle().trim().isEmpty()) {
            changeTitle(updatePostDto.getTitle());
        }
        if(updatePostDto.getContents() != null && !updatePostDto.getContents().trim().isEmpty()) {
            changeContents(updatePostDto.getContents());
        };
    }

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContents(String contents){
        this.contents = contents;
    }
}
