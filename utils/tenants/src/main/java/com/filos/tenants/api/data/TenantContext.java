package com.filos.tenants.api.data;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Data;

@Data
@Component
@RequestScope
public class TenantContext {
    public  void setCurrentTenant(Tenant tenant) {
    }
}
