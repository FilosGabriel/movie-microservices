package com.filos.gateway.filters;

import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.filos.gateway.tenants.TenantRepository;
import reactor.core.publisher.Mono;

@Component
public class TenantsFilter implements GlobalFilter {
    public final static String TENANT_HEADER = "Tenant-X-id";
    public final static String NO_TENANT = "0000-0000-0000-0000-0000";
    public final static String TENANT_PERMISSION_HEADER = "Tenant-X-permission";
    private final TenantRepository repository;

    public TenantsFilter(TenantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String tenant = exchange.getAttribute(TENANT_HEADER);
        Set<String> tenantPermissions = repository.getTenant(tenant);
        return null;
    }
}
