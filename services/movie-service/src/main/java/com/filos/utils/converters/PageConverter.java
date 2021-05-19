package com.filos.utils.converters;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.filos.repository.model.Movie;
import com.filos.utils.mapper.MovieMapper;
import com.filos.web.requests.OriginalRequest;
import com.filos.web.responses.PagedResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PageConverter<T> {
    //    Fix return type
    private final MovieMapper mapper;

    public PagedResponse<Object> convertToPage(OriginalRequest request, Page<Movie> page) {
        return PagedResponse.builder()
                            .data(page.get()
                                      .map(mapper::mapFromData)
                                      .collect(Collectors.toList()))
                            .currentPage(page.getPageable().getPageNumber())
                            .totalPages(page.getTotalPages())
                            .sizePage(page.getPageable().getPageSize())
                            .request(request)
                            .build();
    }
}
