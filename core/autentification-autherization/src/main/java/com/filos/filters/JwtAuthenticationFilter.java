package com.filos.filters;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filos.config.properties.SecurityProperties;
import com.filos.dto.LoginRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.filos.config.constants.Messages.ERROR_MESSAGE;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    private final ObjectMapper mapper;
    private final AuthenticationManager manager;
    private final SecurityProperties properties;

    public JwtAuthenticationFilter(ObjectMapper mapper, AuthenticationManager manager, SecurityProperties properties) {
        this.mapper = mapper;
        this.manager = manager;
        this.properties = properties;
        setFilterProcessesUrl("/api/services/users/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            String requestBody = IOUtils.toString(request.getReader());
            LoginRequest loginRequest = mapper.readValue(requestBody, LoginRequest.class);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.login(), loginRequest.password());
            setDetails(request, token);
            return manager.authenticate(token);
        } catch (IOException e) {
            throw new InternalAuthenticationServiceException(ERROR_MESSAGE, e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) {


        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + properties.expirationTime))
                .sign(HMAC512(properties.secret.getBytes()));
        res.addHeader(properties.Header, properties.tokenPrefix + token);
    }

}
