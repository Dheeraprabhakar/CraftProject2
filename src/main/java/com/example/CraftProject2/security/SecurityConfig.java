package com.example.CraftProject2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // disable CSRF for simplicity, consider enabling in production
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/leaderboard/register").hasRole("ADMIN") // Only ADMIN can register
                        .requestMatchers("/api/leaderboard/top").permitAll()           // Anyone can access top scores
                        .anyRequest().authenticated()
                )
                .httpBasic(); // Use HTTP Basic authentication

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        // Creating an admin user
        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("adminpass")
                        .roles("ADMIN")
                        .build()
        );

        // Creating a regular user
        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("userpass")
                        .roles("USER")
                        .build()
        );

        return manager;
    }
}
