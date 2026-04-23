package com.backend.cms.controller;

import com.backend.cms.apiResponse.InfiniteScrollResponse;
import com.backend.cms.dto.requestDto.BlogRequestDto;
import com.backend.cms.dto.responseDto.BlogResponseDto;
import com.backend.cms.service.BlogService;
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

    @GetMapping("/getAll")
    public List<BlogResponseDto> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping
    public InfiniteScrollResponse<BlogResponseDto> getBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return blogService.getPaginatedBlogs(page, size);
    }
}
