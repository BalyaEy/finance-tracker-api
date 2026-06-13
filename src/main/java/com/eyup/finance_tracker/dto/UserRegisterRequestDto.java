package com.eyup.finance_tracker.dto;

import lombok.Data;

@Data
public class UserRegisterRequestDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
