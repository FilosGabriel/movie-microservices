package com.filos.controller;


import com.filos.api.TenantRepository;
import com.filos.api.data.Tenant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class TenantExtractorFilter extends OncePerRequestFilter{
    private final static String TENANT_HEADER = "Tenant-X-id";
    private final static String NO_TENANT = "0000-0000-0000-0000-0000";
    private final static String TENANT_PERMISSION_HEADER = "Tenant-X-permission";
    private final TenantRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        extractTenantId((HttpRequest) request)
                .stream()
                .map(repository::findByExternalId)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Tenant::getValuesPermissions)
                .forEach(permissions -> request.setAttribute(TENANT_PERMISSION_HEADER, permissions));
        filterChain.doFilter(request, response);
    }


    private Optional<String> extractTenantId(HttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        if (headers.containsKey(TENANT_HEADER)) {
            List<String> values = headers.get(TENANT_HEADER);
            if (Objects.nonNull(values) && (values.size() != 1)) {
                throw new RuntimeException();
            }
            return Optional.ofNullable(values.get(0));
        }
        return Optional.of(NO_TENANT);
    }
}
