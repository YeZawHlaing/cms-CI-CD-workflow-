package com.backend.cms.controller;

import com.backend.cms.dto.requestDto.BlogRequestDto;
import com.backend.cms.dto.responseDto.BlogResponseDto;
import com.backend.cms.model.Blog;
import com.backend.cms.service.BlogService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping
    public BlogResponseDto createBlog(@RequestBody BlogRequestDto request) {
        return blogService.createBlog(request);
    }

    @GetMapping
    public List<BlogResponseDto> getAllBlogs() {
        return blogService.getAllBlogs();
    }
}
