package com.eyup.finance_tracker.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
}
