package com.fridge_raid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

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
                .requestMatchers("/api/user/join", "/api/user/login").permitAll()

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
    
}
