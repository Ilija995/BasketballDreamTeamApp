package com.makons.dreamteam.model.data;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

	private String role;

	public Authority(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return role;
	}
}
