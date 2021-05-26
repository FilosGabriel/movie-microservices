package com.filos.gateway.tenants;

import java.util.Set;

public class Tenant {
    private String id;
    private Set<String> permisions;

    public Tenant(String id, Set<String> permisions) {
        this.id = id;
        this.permisions = permisions;
    }

    public String getId() {
        return id;
    }

    public Set<String> getPermisions() {
        return permisions;
    }
}

