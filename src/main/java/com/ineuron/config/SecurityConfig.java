package com.ineuron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                request -> request.requestMatchers("/api/home" , "/api" , "/api/")
                        .permitAll()
                        .requestMatchers("/api/afterLogin").authenticated()
                        .anyRequest().permitAll()
        ).formLogin(
                form -> form.loginPage("/api/login").defaultSuccessUrl("/api/afterLogin").permitAll()
        ).oauth2Login(
                oauth -> oauth.defaultSuccessUrl("/api/afterLogin")
        );



        return http.build();
    }
}
