package com.fbs.central_api.filter;

import com.fbs.central_api.service.UserService;
import com.fbs.central_api.utility.AuthUtility;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class AuthFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);

    UserService userService;
    AuthUtility authUtility;

    @Autowired
    public AuthFilter(UserService userService,
                      AuthUtility authUtility){
        this.userService = userService;
        this.authUtility = authUtility;
    }

    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Log request URL
        log.debug("AuthFilter triggered for request: {}", request.getRequestURI());

        String bearerToken = request.getHeader("Authorization");

        // Checking Authorization header
        if(bearerToken == null){
            log.debug("No Authorization header found. Proceeding without authentication.");
        }

        if(bearerToken != null && bearerToken.startsWith("Bearer ")){

            log.debug("Authorization header found. Extracting token.");

            String token = bearerToken.substring(7);

            log.debug("Validating JWT token...");

            boolean isValid = userService.validateToken(token);

            if(!isValid){
                log.warn("Invalid JWT token received. Rejecting request: {}", request.getRequestURI());
                filterChain.doFilter(request, response);
                return;
            }

            log.debug("JWT token is valid. Decrypting token to fetch payload.");

            String payload = authUtility.decryptJwtToken(token);

            log.debug("Token payload extracted: {}", payload);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(payload, null, Collections.emptyList());

            log.debug("Setting authentication in SecurityContext for payload: {}", payload);

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        } else {
            log.debug("Authorization header missing or not a Bearer token. Skipping authentication.");
        }

        log.debug("Continuing filter chain for request: {}", request.getRequestURI());
        filterChain.doFilter(request, response);
    }
}
