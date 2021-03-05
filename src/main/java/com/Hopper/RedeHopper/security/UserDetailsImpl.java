package com.Hopper.RedeHopper.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID= 1L;
	
	private String userName;
	private String password;
	
	public UserDetailsImpl() {}
	
	public UserDetailsImpl(UsuarioEntidade user) {
		super();
		this.userName = user.getNome();
		this.password = user.getSenha();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
