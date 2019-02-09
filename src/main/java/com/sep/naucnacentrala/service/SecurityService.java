package com.sep.naucnacentrala.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.sep.naucnacentrala.config.SecurityConfig;
import com.sep.naucnacentrala.model.Korisnik;

@Service
public class SecurityService {
	
	private final KorisnikService userService;
	private final SecurityConfig securityConfig;

	@Autowired
	public SecurityService(KorisnikService userService, SecurityConfig securityConfig) {
		this.userService = userService;
		this.securityConfig = securityConfig;
	}
	

	public Korisnik login(Korisnik user) {
		try {
			UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
			Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
			grantedAuthorities.add(new SimpleGrantedAuthority(user.getUloga()));
			Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, user.getLozinka(), grantedAuthorities);
			
			try {
				//authenticationManager.authenticate(authenticationToken);
				securityConfig.authProvider().authenticate(authenticationToken);
			} catch (org.springframework.security.core.AuthenticationException exc) {
				System.out.println(exc.getMessage());
			}
						
			if(authenticationToken.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				Korisnik u = userService.findByEmail(user.getEmail());
				return u;
			}
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	
	public void logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
	}


	public String getRoleOfLoggedUser() {
		String role;
		if(SecurityContextHolder.getContext().getAuthentication() != null) {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			role = userService.findByEmail(username).getUloga();
			return role;
		}
		return "";
	}


	public Korisnik getLoggedUser() {
		if(SecurityContextHolder.getContext().getAuthentication() != null) {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userService.findByEmail(username);
		}
		return null;
	}

}
