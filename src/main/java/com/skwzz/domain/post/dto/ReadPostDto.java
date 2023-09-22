package com.skwzz.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
public class ReadPostDto {
    private Long id;
    private String title;
    private String contents;
    private String createdDate;
    private String modifiedDate;

    @Builder
    public ReadPostDto(Long id, String title, String contents, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.modifiedDate = modifiedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
