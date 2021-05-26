package com.filos.gateway.tenants;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class TenantRepository {
    private final Map<String, Set<String>> tenants;

    public TenantRepository() {
        tenants = new HashMap<>();
    }

    public Set<String> getTenant(String id) {
        if (tenants.containsKey(id)) {
            return tenants.get(id);
        }
        return Set.of();
    }

    @PostConstruct
    public void init() {
        tenants.put("0000-0000-0000-0000-0000", Set.of("r-movie-id"));
    }
}
