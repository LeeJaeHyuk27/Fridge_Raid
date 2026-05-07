package com.fridge_raid.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth
                // 누구나 접근 가능
                .requestMatchers(
                		"/api/user/join", "/api/user/login", "/api/user/logout", "/api/user/userCheck"
                ).permitAll()

                // 로그인 필요
                .requestMatchers("/api/fridge/**").authenticated()
                .requestMatchers("/api/review/**").authenticated()
                .requestMatchers("/api/recipe/write").authenticated()

                // 나머지 전부 허용
                .anyRequest().permitAll()
            )
            .formLogin(form -> form.disable());

        return http.build();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        // React 주소 허용
        configuration.setAllowedOrigins(
                List.of("http://localhost:3000")
        );

        // 허용 메서드
        configuration.setAllowedMethods(
                List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );

        // 모든 헤더 허용
        configuration.setAllowedHeaders(List.of("*"));

        // 세션 쿠키 허용
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
    
}
