package com.djamel.security;



import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.djamel.entities.Employe;
import com.djamel.entities.Role;
 
 
/**
 * @author Ramesh Fadatare
 *
 */
public class AuthenticatedUser extends org.springframework.security.core.userdetails.User
{

	private static final long serialVersionUID = 1L;
	private Employe employe;
	
	public AuthenticatedUser(Employe employe)
	{
		super(employe.getName(), employe.getPassword(), getAuthorities(employe));
		this.employe = employe;
	}
	
	public Employe getEmploye()
	{
		return employe;
	}
	
	private static Collection<? extends GrantedAuthority> getAuthorities(Employe employe)
	{
		Set<String> roleAndPermissions = new HashSet<>();
		List<Role> roles = employe.getRoles();
		
		for (Role role : roles)
		{
			roleAndPermissions.add(role.getName());
		}
		String[] roleNames = new String[roleAndPermissions.size()];
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
		return authorities;
	}
}
