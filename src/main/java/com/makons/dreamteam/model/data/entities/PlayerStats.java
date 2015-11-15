package com.makons.dreamteam.model.data.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
public class PlayerStats extends Entity {


	@JsonProperty("year")
	private int year;

	@JsonProperty("gp")
	private int gamesPlayed;

	@JsonProperty("min")
	private int minutes;

	@JsonProperty("pts")
	private int points;

	@JsonProperty("oreb")
	private int offRebounds;

	@JsonProperty("dreb")
	private int deffRebounds;

	@JsonProperty("reb")
	private int rebounds;

	@JsonProperty("asts")
	private int assists;

	@JsonProperty("stl")
	private int steals;

	@JsonProperty("blk")
	private int blocks;

	@JsonProperty("to")
	private int turnovers;

	@JsonProperty("pf")
	private int personalFouls;

	@JsonProperty("fga")
	private int fieldGoalsAttempted;

	@JsonProperty("fgm")
	private int fieldGoalsMade;

	@JsonProperty("fta")
	private int freeThrowsAttempted;

	@JsonProperty("ftm")
	private int freeThrowsMade;

	@JsonProperty("tpa")
	private int threePointsAttempted;

	@JsonProperty("tpm")
	private int threePointsMade;

	public int getYear() {
		return year;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getPoints() {
		return points;
	}

	public int getOffRebounds() {
		return offRebounds;
	}

	public int getDeffRebounds() {
		return deffRebounds;
	}

	public int getRebounds() {
		return rebounds;
	}

	public int getAssists() {
		return assists;
	}

	public int getSteals() {
		return steals;
	}

	public int getBlocks() {
		return blocks;
	}

	public int getTurnovers() {
		return turnovers;
	}

	public int getPersonalFouls() {
		return personalFouls;
	}

	public int getFieldGoalsAttempted() {
		return fieldGoalsAttempted;
	}

	public int getFieldGoalsMade() {
		return fieldGoalsMade;
	}

	public int getFreeThrowsAttempted() {
		return freeThrowsAttempted;
	}

	public int getFreeThrowsMade() {
		return freeThrowsMade;
	}

	public int getThreePointsAttempted() {
		return threePointsAttempted;
	}

	public int getThreePointsMade() {
		return threePointsMade;
	}

	@Override
	public int getScore() {
		return points + rebounds + assists + steals + blocks - (freeThrowsAttempted - freeThrowsMade) - (fieldGoalsAttempted - fieldGoalsMade) - (turnovers - steals);
	}
}
