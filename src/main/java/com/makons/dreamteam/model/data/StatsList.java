package com.makons.dreamteam.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.makons.dreamteam.model.data.entities.PlayerStats;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
		"players"
})
public class StatsList {

	/**
	 * (Required)
	 */
	@JsonProperty("players")
	private List<PlayerStats> stats = new ArrayList<PlayerStats>();
	@JsonIgnore

	/**
	 * (Required)
	 * @return
	 *     The players
	 */
	@JsonProperty("players")
	public List<PlayerStats> getPlayerStats() {
		return stats;
	}

	public void printID() {
		for (PlayerStats ps : stats) {
			System.out.println(ps.getId());
		}
	}
}