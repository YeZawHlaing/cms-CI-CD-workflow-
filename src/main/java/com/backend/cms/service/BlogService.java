package com.backend.cms.service;

import com.backend.cms.dto.requestDto.BlogRequestDto;
import com.backend.cms.dto.responseDto.BlogResponseDto;
import java.util.List;

public interface BlogService {

    BlogResponseDto createBlog(BlogRequestDto request);

    List<BlogResponseDto> getAllBlogs();
}
