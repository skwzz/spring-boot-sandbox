package com.skwzz.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@Getter
public class ReadPostDto {
    private Long id;
    private String title;
    private String contents;

    @Builder
    public ReadPostDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
