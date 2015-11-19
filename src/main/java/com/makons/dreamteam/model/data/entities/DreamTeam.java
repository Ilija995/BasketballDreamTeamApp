package com.makons.dreamteam.model.data.entities;

import com.makons.dreamteam.model.data.Position;

import java.util.HashMap;
import java.util.Map;

public class DreamTeam extends Entity implements Comparable<DreamTeam> {

	public static int dreamTeamCount = 0;

	/** Name of the team */
	private String name;

	/** Map of the players and their positions */
	private Map<Position, Player> players;

	private int score = Integer.MIN_VALUE;

	/**
	 * Default constructor
	 */
	public DreamTeam(String name, Map<Position, Player> players) {
		super();

		setId("DREAMTEAM" + dreamTeamCount);
		this.players = new HashMap<>(players);
		if (name.trim().length() > 0) {
			this.name = name;
		}
		else {
			this.name = "Team " + ++dreamTeamCount;
		}
	}

	public String getName() {
		return name;
	}

	public Map<Position, Player> getPlayers() {
		return players;
	}

	/**
	 * Returns score of the team which is the sum of each players score
	 */
	@Override
	public int getScore() {
		if (score == Integer.MIN_VALUE) {
			score = 0;
			players.values().stream().forEach(player -> score += player.getScore());
		}
		return score;
	}

	@Override
	public int compareTo(DreamTeam that) {
		return that.getScore() - this.getScore();
	}
}