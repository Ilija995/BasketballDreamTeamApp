package com.makons.dreamteam.model.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.makons.dreamteam.model.data.Position;

import java.util.List;

public class Player extends Entity implements Comparable<Player> {

	@JsonProperty("firstname")
	/** Player's first name */
	private String firstName;

	@JsonProperty("lastname")
	/** Player's last name */
	private String lastName;

	@JsonProperty("team")
	/** Player's team */
	private String team;

	@JsonProperty("leag")
	/** Player's league */
	private String league;

	@JsonProperty("pos")
	/** Positions that can this player play */
	private List<Position> positions;

	/** Player statistics */
	private PlayerStats stats;

	public Player() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTeam() {
		return team;
	}

	public String getLeague() {
		return league;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public PlayerStats getStats() {
		return stats;
	}

	public void setStats(PlayerStats stats) {
		this.stats = stats;
	}

	@Override
	public int getScore() {
		return stats.getScore();
	}

	@Override
	public int compareTo(Player that) {
		return that.getScore() - this.getScore();
	}
}
