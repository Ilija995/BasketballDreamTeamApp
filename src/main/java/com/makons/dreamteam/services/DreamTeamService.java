package com.makons.dreamteam.services;

import com.makons.dreamteam.model.data.Position;
import com.makons.dreamteam.model.data.entities.DreamTeam;
import com.makons.dreamteam.model.data.entities.Player;
import com.makons.dreamteam.model.data.entities.User;
import com.makons.dreamteam.model.repo.PlayerRepo;
import com.makons.dreamteam.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@Service
public class DreamTeamService {

	private PlayerRepo playerRepo;

	private UserRepo userRepo;

	@Autowired
	public DreamTeamService(PlayerRepo playerRepo, UserRepo userRepo) {
		this.playerRepo = playerRepo;
		this.userRepo = userRepo;
	}

	public PriorityQueue<DreamTeam> getDreamTeams() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDetails userDetails = userRepo.loadUserByUsername(username);

		return ((User) userDetails).getTeams();
	}

	public PriorityQueue<DreamTeam> setDreamTeam(String pgId, String sgId, String sfId, String pfId, String cId, String teamName) {

		Map<Position, Player> playerMap = new HashMap<>();
		playerMap.put(Position.POINT_GUARD, (Player) playerRepo.get(pgId));
		playerMap.put(Position.SHOOTING_GUARD, (Player) playerRepo.get(sgId));
		playerMap.put(Position.SMALL_FORWARD, (Player) playerRepo.get(sfId));
		playerMap.put(Position.POWER_FORWARD, (Player) playerRepo.get(pfId));
		playerMap.put(Position.CENTER, (Player) playerRepo.get(cId));

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDetails userDetails = userRepo.loadUserByUsername(username);
		User user = (User) userDetails;
		user.addTeam(new DreamTeam(teamName, playerMap));

		return user.getTeams();
	}
}
