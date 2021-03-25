package com.filos.controller;

import com.filos.api.InboundRequest;
import com.filos.api.TenantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;


@Log4j2
@Aspect
@Component
@RequiredArgsConstructor
public class MultiTentantAspect{
    private final HttpRequest request;
    private final TenantRepository tenantRepository;

    @Around("@annotation(com.filos.api.InboundRequest)")
    public Object logInboundRequests(ProceedingJoinPoint point) throws Throwable {
        String[] permissions = getPermissionForMethodExecution(point.getSignature());
        return point.proceed();

    }

    private boolean hasPermissionForAccess(){
        request.
    }

    private String[] getPermissionForMethodExecution(Signature signature) {
        return ((MethodSignature) signature).getMethod()
                .getAnnotation(InboundRequest.class)
                .operations();
    }

}
