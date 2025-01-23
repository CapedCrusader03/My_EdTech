package com.kshitij.edtech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for testing purposes
            .authorizeHttpRequests()
            .requestMatchers(
                "/api/users/register", // Registration endpoint
                "/api/performance/**", // Allow all performance endpoints
                "/api/attendance/**",   // Allow all attendance endpoints
                "/api/notifications/**"   // Allow all attendance endpoints
            ).permitAll() // Allow unauthenticated access to these endpoints
            .anyRequest().authenticated() // All other endpoints require authentication
            .and()
            .httpBasic(); // Enable basic authentication for protected endpoints

        return http.build();
    }
}
