package com.backend.cms.mapper.requestMapper;

import com.backend.cms.dto.requestDto.BlogRequestDto;
import com.backend.cms.model.Blog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogRequestMapper {
    Blog toEntity(BlogRequestDto dto);
}
