package com.example.library.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()

                .authorizeHttpRequests()

                .requestMatchers(new AntPathRequestMatcher("/**", HttpMethod.GET.toString())).hasAnyRole("USER", "ADMIN")


                .requestMatchers(new AntPathRequestMatcher("/borrowing/**", HttpMethod.POST.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/borrowing/**", HttpMethod.PUT.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/borrowing/**", HttpMethod.DELETE.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/publication_available_notification_request/**", HttpMethod.POST.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/publication_available_notification_request/**", HttpMethod.PUT.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/publication_available_notification_request/**", HttpMethod.DELETE.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/rating/**", HttpMethod.POST.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/rating/**", HttpMethod.PUT.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/rating/**", HttpMethod.DELETE.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/reservation/**", HttpMethod.POST.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/reservation/**", HttpMethod.PUT.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/reservation/**", HttpMethod.DELETE.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/review/**", HttpMethod.POST.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/review/**", HttpMethod.PUT.toString())).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/review/**", HttpMethod.DELETE.toString())).hasAnyRole("USER", "ADMIN")

                .requestMatchers(new AntPathRequestMatcher("/user/**", HttpMethod.POST.toString())).hasRole("USER")
                .requestMatchers(new AntPathRequestMatcher("/user/**", HttpMethod.PUT.toString())).hasRole("USER")
                .requestMatchers(new AntPathRequestMatcher("/user/**", HttpMethod.PUT.toString())).hasRole("USER")
                .requestMatchers("auth/**")// TODO change url
                .permitAll()
                .anyRequest()
                .hasRole("ADMIN")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}
