package com.example.inbound.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityFilterChain {
	
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable();

	        // 기본 설정인 Session 방식 사용하지 않고 JWT 방식 사용
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	        http.authorizeRequests().requestMatchers("/api/**").permitAll()
	                .requestMatchers(HttpMethod.GET, "/**").permitAll()
	                .anyRequest().authenticated();


	        return http.build();
	    }
	
}
