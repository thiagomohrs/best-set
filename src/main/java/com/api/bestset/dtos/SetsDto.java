package com.api.bestset.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
public class SetsDto {

    private UUID huntId;

    @NotBlank
    private String helmet;

    @NotBlank
    private String armor;
    
    @NotBlank
    private String leg;
    
    @NotBlank
    private String boot;

    @NotBlank
    private String shield;
    
    @NotBlank
    private String weapom;

    @NotBlank
    private String ring;

    @NotBlank
    private String amulet;

    @NotBlank
    private String light;

    @NotBlank
    private String rune;

    @PositiveOrZero
    private Integer votes;

    private LocalDateTime createdDate;
    
    private String createdUser;

    private LocalDateTime lastUpdatedDate;
    
    private String lastUpdatedUser;

}