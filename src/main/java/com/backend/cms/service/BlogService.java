package com.backend.cms.service;

import com.backend.cms.apiResponse.InfiniteScrollResponse;
import com.backend.cms.dto.requestDto.BlogRequestDto;
import com.backend.cms.dto.responseDto.BlogResponseDto;
import org.hibernate.query.Page;

import java.util.List;

public interface BlogService {

    BlogResponseDto createBlog(BlogRequestDto request);

    List<BlogResponseDto> getAllBlogs();

    InfiniteScrollResponse<BlogResponseDto> getPaginatedBlogs(int page, int size);

    }
