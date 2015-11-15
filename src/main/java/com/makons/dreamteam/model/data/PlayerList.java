package com.makons.dreamteam.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.makons.dreamteam.model.data.entities.Player;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
		"players"
})
public class PlayerList {

	/**
	 * (Required)
	 */
	@JsonProperty("players")
	private List<Player> players = new ArrayList<Player>();
	@JsonIgnore

	/**
	 * (Required)
	 * @return
	 *     The players
	 */
	@JsonProperty("players")
	public List<Player> getPlayers() {
		return players;
	}

	public int getPlayerCount() {
		return players.size();
	}

	public void printID() {
		for (Player s : players) {
			System.out.println(s.getId());
		}
	}
}
