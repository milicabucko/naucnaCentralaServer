package com.sep.naucnacentrala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sep.naucnacentrala.service.UserDetailServiceImpl;


//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailServiceImpl userDetailService;

	public SecurityConfig(UserDetailServiceImpl userDetailService) {
		this.userDetailService = userDetailService;
	}
	
	//@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
			.and()
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/api/auth/**").permitAll()
				//.antMatchers("/api/users/getLoggedUser").permitAll()
				.antMatchers("/korisnik/registration/**").permitAll()
				.antMatchers("/korisnik/login/**").permitAll()
				.antMatchers("/korisnik/commonPassword/**").permitAll()
				.anyRequest()
				.authenticated();
	}

	//@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	//@Bean
	//@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	 
	//@Bean
	public DaoAuthenticationProvider authProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailService);
	    authProvider.setPasswordEncoder(getPasswordEncoder());
	    return authProvider;
	}
	
	//@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
