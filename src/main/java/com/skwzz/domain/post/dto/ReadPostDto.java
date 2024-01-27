package com.skwzz.domain.post.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    @Getter
    @Setter
    public static class Response {
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private ReadPostDto post;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private List<ReadPostDto> postList;

        public Response(ReadPostDto post){
            this.post = post;
        }

        public Response(List<ReadPostDto> postList){
            this.postList = postList;
        }
    }
}
