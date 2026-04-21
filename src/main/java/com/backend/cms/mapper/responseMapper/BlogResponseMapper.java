package com.backend.cms.mapper.responseMapper;

import com.backend.cms.dto.responseDto.BlogResponseDto;
import com.backend.cms.model.Blog;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlogResponseMapper {
    BlogResponseDto toDto(Blog blog);

    List<BlogResponseDto> toDtoList(List<Blog> blogs);
}
