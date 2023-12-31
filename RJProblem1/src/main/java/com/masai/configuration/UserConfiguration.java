package com.masai.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration {
	
	@Bean
	public SecurityFilterChain userSecurity(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth) -> auth
				.requestMatchers("/masai/security").authenticated()
				.requestMatchers("/masai/employee/admin").hasRole("admin")
				.requestMatchers("/masai/welcome","/masai/employee/register").permitAll()
				).csrf().disable()
		.httpBasic();
		
		return http.build();
	}
	
//	@Bean
//	public InMemoryUserDetailsManager userDetails() {
//	
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//	  UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
//	    UserDetails user = User.withUsername("user").password("12345").authorities("read").build();
//	    userDetailsService.createUser(admin);
//	    userDetailsService.createUser(user);
//	    return userDetailsService;
//	}
	

	 @Bean
	 public PasswordEncoder passwordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
		}
}
