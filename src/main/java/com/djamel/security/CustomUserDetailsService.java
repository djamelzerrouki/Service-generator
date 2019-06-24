package com.djamel.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djamel.entities.Employe;
import com.djamel.repositories.RepoEmploye;

/**
 * @author Ramesh Fadatare
 *
 */
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private RepoEmploye employeRepository;
	public static Employe empl ;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Employe employe = employeRepository.findByName(name) 	
				.orElseThrow(() -> new UsernameNotFoundException("username " + name + " not found"));
		empl=employe;
		return new org.springframework.security.core.userdetails.User(employe.getName(), employe.getPassword(),
				getAuthorities(employe));
	}
	
	private static Collection<? extends GrantedAuthority> getAuthorities(Employe employe) {
		String[] employeRoles = employe.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(employeRoles);
		return authorities;
	}
}
