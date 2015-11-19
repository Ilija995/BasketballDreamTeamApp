package com.makons.dreamteam.model.data.entities;

import com.makons.dreamteam.model.data.Authority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class User extends Entity implements Comparable<User>, UserDetails {

	private String password;

	private boolean enabled;

	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private Collection<Authority> authorities;

	private int score;

	private PriorityQueue<DreamTeam> teams;

	public User(String username, String password) {
		this(username, password, new HashSet<>(Arrays.asList(new Authority("ROLE_USER"))));
	}

	public User(String username, String password, Collection<Authority> authorities) {
		this(username, password, true, true, true, true, authorities);
	}

	public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, Collection<Authority> authorities) {

		setId(username);
		this.password = password;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.authorities = authorities;
		this.score = Integer.MIN_VALUE;
		this.teams = new PriorityQueue<>();
	}

	public void addTeam(DreamTeam team) {
		if (team != null) {
			teams.add(team);
			if (team.getScore() > score) {
				score = team.getScore();
			}
		}
	}

	@Override
	public String getUsername() {
		return getId();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public Collection<Authority> getAuthorities() {
		return authorities;
	}

	public PriorityQueue<DreamTeam> getTeams() {
		return teams;
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(User that) {
		return that.getScore() - this.getScore();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		StringBuilder auth = new StringBuilder();
		getAuthorities().stream().forEach(authority -> auth.append(authority.getAuthority() + ", "));

		sb.append("Username: " + getUsername() + "\n")
			.append("Password: " + getPassword() + "\n")
			.append("Enabled: " + isEnabled() + "\n")
			.append("Account Non Expired: " + isAccountNonExpired() + "\n")
			.append("Account Non Locked: " + isAccountNonLocked() + "\n")
			.append("CredentialsNonExpired: " + isCredentialsNonExpired() + "\n")
			.append("Authorities: " + auth + "\n")
			.append("Score:" + getScore() + "\n");

		return sb.toString();
	}
}
