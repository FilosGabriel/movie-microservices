package com.filos.web.responses;

import java.util.List;

import com.filos.web.requests.OriginalRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PagedResponse<T> {
    private final long currentPage;
    private final long totalPages;
    private final long sizePage;
    private final OriginalRequest request;
    private final List<T> data;

    public static <T> PagedResponseBuilder<T> builder() {
        return new PagedResponseBuilder<T>();
    }

    public static class PagedResponseBuilder<T> {
        private long currentPage;
        private long totalPages;
        private long sizePage;
        private OriginalRequest request;
        private List<T> data;

        PagedResponseBuilder() {
        }

        public PagedResponseBuilder<T> currentPage(long currentPage) {
            this.currentPage = currentPage;
            return this;
        }

        public PagedResponseBuilder<T> totalPages(long totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public PagedResponseBuilder<T> sizePage(long sizePage) {
            this.sizePage = sizePage;
            return this;
        }

        public PagedResponseBuilder<T> request(OriginalRequest request) {
            this.request = request;
            return this;
        }

        public PagedResponseBuilder<T> data(List<T> data) {
            this.data = data;
            return this;
        }

        public PagedResponse<T> build() {
            return new PagedResponse<T>(currentPage, totalPages, sizePage, request, data);
        }

        public String toString() {
            return "PagedResponse.PagedResponseBuilder(currentPage=" + this.currentPage + ", totalPages=" + this.totalPages + ", sizePage="
                    + this.sizePage + ", request=" + this.request + ", data=" + this.data + ")";
        }
    }
}
