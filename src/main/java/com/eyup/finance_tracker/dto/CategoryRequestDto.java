package com.eyup.finance_tracker.dto;

import lombok.Data;

@Data
public class CategoryRequestDto {
    private String categoryName;
    private String categoryType;
    private Long userId;
}
