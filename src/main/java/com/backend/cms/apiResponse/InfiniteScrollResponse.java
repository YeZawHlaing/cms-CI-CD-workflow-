package com.backend.cms.apiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InfiniteScrollResponse<T> {
    private List<T> content;
    private boolean hasNext;
    private int nextPage;
}