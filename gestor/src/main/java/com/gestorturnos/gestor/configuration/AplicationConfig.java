package com.gestorturnos.gestor.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AplicationConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails guada = User.builder()
            .username("guada")
            .password("{noop}admin")
            .roles("ADMIN")
            .build();

        UserDetails valen = User.builder()
            .username("valen")
            .password("{noop}admin")
            .roles("ADMIN", "MANAGER", "EMPLOYEE")
            .build();

        return new InMemoryUserDetailsManager(guada, valen);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer ->
            configurer
                .requestMatchers(HttpMethod.GET).hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
        );

        // Utiliza HTTP Basic Authentication
        httpSecurity.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
