package com.skwzz.domain.post.dto;

import com.skwzz.global.constants.ValidError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostDto {

    @NotBlank(message = ValidError.REQUIRED_POST_ID)
    private Long id;

    @NotBlank(message = ValidError.REQUIRED_TITLE)
    private String title;

    @NotBlank(message = ValidError.REQUIRED_CONTENTS)
    private String contents;
}
