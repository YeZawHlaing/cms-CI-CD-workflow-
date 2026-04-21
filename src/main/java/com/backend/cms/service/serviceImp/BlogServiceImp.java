package com.backend.cms.service.serviceImp;

import com.backend.cms.dto.requestDto.BlogRequestDto;
import com.backend.cms.dto.responseDto.BlogResponseDto;
import com.backend.cms.mapper.requestMapper.BlogRequestMapper;
import com.backend.cms.mapper.responseMapper.BlogResponseMapper;
import com.backend.cms.model.Blog;
import com.backend.cms.repo.BlogRepo;
import com.backend.cms.service.BlogService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImp implements BlogService {

    private final BlogRepo blogRepo;
    private final BlogRequestMapper requestMapper;
    private final BlogResponseMapper responseMapper;


    @Override
    public BlogResponseDto createBlog(BlogRequestDto request) {
        Blog blog = requestMapper.toEntity(request);

        blog.setPost_date(LocalDateTime.now());

        Blog saved = blogRepo.save(blog);

        return responseMapper.toDto(saved);
    }

    @Override
    public List<BlogResponseDto> getAllBlogs() {
        List<Blog> blogs = blogRepo.findAll();
        return responseMapper.toDtoList(blogs);
    }
}
