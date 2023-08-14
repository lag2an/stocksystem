package com.gyslab.stocksystem.accountservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return 
			http.authorizeHttpRequests(authorize -> {
				authorize
					.requestMatchers(HttpMethod.GET, "/**").hasAuthority("SCOPE_account:read")
					.requestMatchers(HttpMethod.POST, "/**").hasAuthority("SCOPE_account:write")
					.anyRequest().authenticated()
			}).oauth2ResourceServer(x -> 
				x.jwt(Customizer.withDefaults())
			).build();
    }

}
