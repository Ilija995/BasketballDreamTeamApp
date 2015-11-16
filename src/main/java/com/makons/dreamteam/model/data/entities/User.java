package com.makons.dreamteam.model.data.entities;

import com.makons.dreamteam.model.data.Authority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;

public class User extends Entity implements Comparable<User>, UserDetails {

	private String password;

	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private boolean enabled;

	private Collection<Authority> authorities;

	private int score;

	private PriorityQueue<DreamTeam> teams;

	public User(String username, String password) {
		this(username, password, null);
	}

	public User(String username, String password, Collection<Authority> authorities) {
		this(username, password, true, true, true, true, authorities);
	}

	public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, Collection<Authority> authorities) {
		super();

		setId(username);
		this.password = password;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.score = Integer.MIN_VALUE;
		this.teams = new PriorityQueue<>();

		if (authorities == null) {
			this.authorities = new HashSet<>();
			this.authorities.add(new Authority("ROLE_USER"));
		}
		else {
			this.authorities = new HashSet<>(authorities);
		}
	}

	@Override
	public String getUsername() {
		return getId();
	}

	@Override
	public String getPassword() {
		return password;
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
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public Collection<Authority> getAuthorities() {
		return authorities;
	}

	public void addTeam(DreamTeam team) {
		if (team != null) {
			teams.add(team);
			if (team.getScore() > score) {
				score = team.getScore();
			}
		}
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
		authorities.stream().forEach(authority -> auth.append(authority.getAuthority() + ", "));

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
