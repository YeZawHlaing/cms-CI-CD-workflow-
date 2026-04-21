package com.backend.cms.service;

import com.backend.cms.model.Blog;

import java.util.List;

public interface BlogService {

    Blog createBlog(Blog blog);
    List<Blog> getAllBlogs();

}
