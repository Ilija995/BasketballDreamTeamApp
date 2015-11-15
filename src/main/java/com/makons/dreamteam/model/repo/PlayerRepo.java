package com.makons.dreamteam.model.repo;

import com.makons.dreamteam.model.data.entities.Player;
import com.makons.dreamteam.model.data.entities.PlayerStats;

import java.util.List;

public class PlayerRepo extends Repo {

	public void setPlayerStats(List<PlayerStats> stats) {
		for (PlayerStats stat : stats) {
			if (entityMap.containsKey(stat.getId())) {
				((Player) entityMap.get(stat.getId())).setStats(stat);
			}
		}
	}
}
