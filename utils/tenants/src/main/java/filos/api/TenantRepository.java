package filos.api;

import java.util.Optional;

import filos.api.data.Tenant;

public interface TenantRepository {
    Optional<Tenant> findByExternalId(String companyId);
}
