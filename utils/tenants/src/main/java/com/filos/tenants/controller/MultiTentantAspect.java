package com.filos.tenants.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import com.filos.tenants.api.InboundRequest;
import com.filos.tenants.api.TenantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Aspect
@Component
@RequiredArgsConstructor
public class MultiTentantAspect {
    private final HttpRequest request;
    private final TenantRepository tenantRepository;

    @Around("@annotation(com.filos.tenants.api.InboundRequest)")
    public Object logInboundRequests(ProceedingJoinPoint point) throws Throwable {
        String[] permissions = getPermissionForMethodExecution(point.getSignature());
        return point.proceed();

    }

    private boolean hasPermissionForAccess() {
        return false;
    }

    private String[] getPermissionForMethodExecution(Signature signature) {
        return ((MethodSignature) signature).getMethod()
                                            .getAnnotation(InboundRequest.class)
                                            .operations();
    }

}
