package com.sep.naucnacentrala.service;

import static java.util.Objects.nonNull;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sep.naucnacentrala.model.Korisnik;
import com.sep.naucnacentrala.repository.KorisnikRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	

	private final KorisnikRepository userRepository;

	public UserDetailServiceImpl(KorisnikRepository userRepository) {
		this.userRepository = userRepository;
	}

	//@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik user = userRepository.findByEmail(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getUloga()));
		if (nonNull(user)) {
			return new org.springframework.security.core.userdetails.User(user.getEmail(),
					user.getLozinka(), grantedAuthorities);
		}
		throw new UsernameNotFoundException("Bad credentials");
	}

}
