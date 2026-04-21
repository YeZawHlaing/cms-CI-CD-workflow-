package com.backend.cms.service.serviceImp;

import com.backend.cms.model.Blog;
import com.backend.cms.repo.BlogRepo;
import com.backend.cms.service.BlogService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImp implements BlogService {

    private final BlogRepo blogRepo;

    @Override
    public Blog createBlog(Blog blog) {
        return blogRepo.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }
}
