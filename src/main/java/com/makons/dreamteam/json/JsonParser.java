package com.makons.dreamteam.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.makons.dreamteam.model.data.*;
import com.makons.dreamteam.model.data.entities.Player;
import com.makons.dreamteam.model.data.entities.PlayerStats;

import java.io.File;
import java.io.IOException;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonParser {

	static private ObjectMapper mapper = new ObjectMapper();

	static public List<Player> deserializePlayers(String filePath) throws IOException {
		PlayerList playerList = mapper.readValue(new File(filePath), PlayerList.class);
		return playerList.getPlayers();
	}

	static public List<PlayerStats> deserializeStats(String filePath) throws IOException {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(new File(filePath), StatsList.class).getPlayerStats();
	}
}
