package com.example.demo.Security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	@Bean
	public UserDetailsService userDetailsService() {
		//UserDetails user= User.withUsername("user").password("user").roles("USER").build();
		//UserDetails admin= User.withUsername("admin").password("admin").roles("ADMIN").build();
		//return new InMemoryUserDetailsManager(user);
		return new UserFileDetailsService();
	}
	
	@Bean
	public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf().disable()
			.authorizeHttpRequests().requestMatchers("/admin/").authenticated()
			.and()
			.authorizeHttpRequests().anyRequest().permitAll()
			.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("email")
				.defaultSuccessUrl("/",true)
			.and()
			.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
}
