package com.makons.dreamteam.config;

import com.makons.dreamteam.model.data.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Override
//	public void configure(WebSecurity web) {
//		web.ignoring().antMatchers("/css/**");
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/css/**").permitAll()
					.antMatchers("/login**").permitAll()
					.antMatchers("/admin**").hasRole("ADMIN")
					.antMatchers("/**").hasRole("USER")
					.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/", true)
					.failureUrl("/login?error")
					.usernameParameter("username")
					.passwordParameter("password")
					.permitAll()
					.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login?logout")
					.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(inMemoryUserDetailsManager());
	}

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		Collection<UserDetails> users = new ArrayList<>(1);
		users.add(new User("admin", "admin"));
		return new InMemoryUserDetailsManager(users);
	}
}
