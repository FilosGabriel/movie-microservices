package com.filos.api;

import com.filos.api.data.Tenant;

import java.util.Optional;

public interface TenantRepository {
    Optional<Tenant> findByExternalId(String companyId);
}
