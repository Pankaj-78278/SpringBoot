package com.masai.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration extends  WebSecurityConfigurerAdapter{
	
	@Bean
	public SecurityFilterChain userSecurity(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth) -> auth
				.antMatchers("/masaimail/login").authenticated()
				.antMatchers("/masaimail/register").permitAll()
				).csrf().disable().httpBasic();
		
		return http.build();
	}

	

	 @Bean
	 public PasswordEncoder passwordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
		}
}
