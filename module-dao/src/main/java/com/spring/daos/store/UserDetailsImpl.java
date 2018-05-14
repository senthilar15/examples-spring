package com.spring.daos.store;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.test.jpa.AppUser;

public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 1L;

	private AppUser user;
	
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl(AppUser user) {
		this.user = user;
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		this.authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(
				user.getRoles().stream().map(a -> a.getRoleName()).collect(Collectors.joining(", ")));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
