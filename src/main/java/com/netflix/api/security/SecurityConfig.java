package com.netflix.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("password").roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((auth) -> auth
                        .antMatchers(HttpMethod.GET).permitAll()
                        //.antMatchers(HttpMethod.POST).hasRole("USER")
                        //.antMatchers(HttpMethod.PUT).hasRole("USER")
                        //.antMatchers(HttpMethod.PATCH).hasRole("USER")
                        //.antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                ).sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable().httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
