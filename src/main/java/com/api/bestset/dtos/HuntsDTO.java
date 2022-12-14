package com.api.bestset.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HuntsDTO {

    @NotBlank
    private String name;

    private LocalDateTime createdDate;

    private String createdUser;
}