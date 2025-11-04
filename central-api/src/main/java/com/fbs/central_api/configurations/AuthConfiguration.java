package com.fbs.central_api.configurations;

import com.fbs.central_api.filter.AuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class AuthConfiguration {

    private static final Logger log = LoggerFactory.getLogger(AuthConfiguration.class);

    @Autowired
    AuthFilter authFilter;

    /**
     * This method sets the security rules for the entire application.
     *
     * - Some endpoints are "permitAll" → no login/token required.
     * - All other endpoints are "authenticated" → token required.
     * - We disable sessions because JWT is stateless.
     * - We add our custom AuthFilter before Spring’s default username/password filter.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        log.debug("Setting up SecurityFilterChain...");

        return http.csrf()
                .disable()
                .authorizeHttpRequests(auth -> {

                    log.debug("Configuring public endpoints (permitAll):");
                    log.debug(" - /api/v1/central/user/login");
                    log.debug(" - /api/v1/central/airline/register");

                    auth.requestMatchers(
                                    "/api/v1/central/user/login",
                                    "/api/v1/central/airline/register")
                            .permitAll();

                    log.debug("Marking all other endpoints as secured (authentication required).");
                    auth.anyRequest().authenticated();  // must send token, and token must be valid
                })
                .sessionManagement(session -> {
                    log.debug("Setting session management to STATELESS (JWT based auth).");
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                // AuthFilter runs BEFORE UsernamePasswordAuthenticationFilter
                // so our token validation happens first
                .build();
    }
}
