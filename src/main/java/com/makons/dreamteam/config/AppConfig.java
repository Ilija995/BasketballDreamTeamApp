package com.makons.dreamteam.config;

import com.makons.dreamteam.model.repo.PlayerRepo;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public PlayerRepo playerRepo() {
		return new PlayerRepo();
	}
}
