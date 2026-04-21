package com.backend.cms.controller;

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
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }
}
