package com.skwzz.domain.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import com.skwzz.global.constants.ValidError;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostDto {

    @NotBlank(message = ValidError.REQUIRED_TITLE)
    private String title;

    @NotBlank(message = ValidError.REQUIRED_CONTENTS)
    private String contents;
}
