package com.filos.api.data;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Data
@Component
@RequestScope
public class TenantContext {
    public  void setCurrentTenant(Tenant tenant) {
    }
}
