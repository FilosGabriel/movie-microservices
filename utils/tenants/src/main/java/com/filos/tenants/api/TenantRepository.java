package com.filos.tenants.api;

import java.util.Optional;

import com.filos.tenants.api.data.Tenant;

public interface TenantRepository {
    Optional<Tenant> findByExternalId(String companyId);
}
