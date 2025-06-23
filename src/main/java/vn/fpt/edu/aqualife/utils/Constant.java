package vn.fpt.edu.aqualife.utils;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class Constant {
    public static final String[] PUBLIC_ENDPOINTS = {"/api/v1/auth/**", "/v2/api-docs",
            "/v3/api-docs", 
            "/ws/**",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html",
            "/api-docs/**",
            "/api/auth/**",
            "/api/firebase/**",
    };

}
