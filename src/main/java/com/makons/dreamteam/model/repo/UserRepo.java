package com.makons.dreamteam.model.repo;

import com.makons.dreamteam.model.data.Authority;
import com.makons.dreamteam.model.data.entities.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Repository
public class UserRepo extends Repo implements UserDetailsManager {

	public UserRepo() {
		createUser(new User("admin", "admin", new ArrayList<>(Arrays.asList(new Authority("ROLE_USER"), new Authority("ROLE_ADMIN")))));
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		return (User) entityMap.get(username);
	}

	@Override
	public boolean userExists(String username) {
		return entityMap.containsKey(username);
	}

	@Override
	public void createUser(UserDetails user) {
		entityMap.put(user.getUsername(), (User) user);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User user = (User) entityMap.remove(username);
		user.setPassword(newPassword);

		entityMap.put(username, user);
	}

	@Override
	public void deleteUser(String username) {
		entityMap.remove(username);
	}

	@Override
	public void updateUser(UserDetails user) {
		entityMap.replace(user.getUsername(), (User) user);
	}
}
