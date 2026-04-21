package com.backend.cms.dto.responseDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BlogResponseDto {

    private Long id;
    private String title;
    private String text;
    private LocalDateTime post_date;
}