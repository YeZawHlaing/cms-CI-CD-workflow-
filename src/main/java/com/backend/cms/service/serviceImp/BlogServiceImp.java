package com.backend.cms.service.serviceImp;

import com.backend.cms.apiResponse.InfiniteScrollResponse;
import com.backend.cms.dto.requestDto.BlogRequestDto;
import com.backend.cms.dto.responseDto.BlogResponseDto;
import com.backend.cms.mapper.requestMapper.BlogRequestMapper;
import com.backend.cms.mapper.responseMapper.BlogResponseMapper;
import com.backend.cms.model.Blog;
import com.backend.cms.repo.BlogRepo;
import com.backend.cms.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImp implements BlogService {

    private final BlogRepo blogRepo;
    private final BlogRequestMapper requestMapper;
    private final BlogResponseMapper responseMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    private static final String BLOG_LIST_KEY = "blogs";


    @Override
    public BlogResponseDto createBlog(BlogRequestDto request) {
        Blog blog = requestMapper.toEntity(request);
        blog.setPost_date(LocalDateTime.now());
        Blog saved = blogRepo.save(blog);

        redisTemplate.delete(BLOG_LIST_KEY);
        return responseMapper.toDto(saved);
    }

    @Override
    public List<BlogResponseDto> getAllBlogs() {

        List<BlogResponseDto> cached =
                (List<BlogResponseDto>) redisTemplate.opsForValue().get(BLOG_LIST_KEY);

        if (cached != null) {
            System.out.println("Blogs from Redis");
            return cached;
        }
        System.out.println("Blogs from DB");
        List<Blog> blogs = blogRepo.findAll();
        List<BlogResponseDto> response = responseMapper.toDtoList(blogs);

        redisTemplate.opsForValue().set(BLOG_LIST_KEY, response, Duration.ofMinutes(5));

        return response;
    }

    @Override
    public InfiniteScrollResponse<BlogResponseDto> getPaginatedBlogs(int page, int size) {
        String key = BLOG_LIST_KEY + "::page=" + page + "::size=" + size;

        InfiniteScrollResponse<BlogResponseDto> cached =
                (InfiniteScrollResponse<BlogResponseDto>) redisTemplate.opsForValue().get(key);

        if (cached != null) {
            System.out.println("Fetched from Redis");
            return cached;
        }

        System.out.println("Fetched from DB");

        // Pagination
        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> blogPage = blogRepo.findAll(pageable);

        List<BlogResponseDto> content = blogPage.getContent()
                .stream()
                .map(responseMapper::toDto)
                .toList();

        InfiniteScrollResponse<BlogResponseDto> response =
                new InfiniteScrollResponse<>(
                        content,
                        blogPage.hasNext(),
                        page + 1
                );

        redisTemplate.opsForValue().set(key, response, Duration.ofMinutes(10));

        return response;
    }
}
