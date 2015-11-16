package com.makons.dreamteam.services;

import com.makons.dreamteam.model.data.PlayerNameComparator;
import com.makons.dreamteam.model.data.Position;
import com.makons.dreamteam.model.data.entities.IEntity;
import com.makons.dreamteam.model.data.entities.Player;
import com.makons.dreamteam.model.data.entities.PlayerStats;
import com.makons.dreamteam.json.JsonParser;
import com.makons.dreamteam.model.repo.PlayerRepo;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class PlayerService {

	private PlayerRepo playerRepo;

	@Value("${environments.filePaths.players}")
	String playersPath;

	@Value("${environments.filePaths.stats}")
	String statsPath;

	@Autowired
	public PlayerService(PlayerRepo playerRepo) {
		this.playerRepo = playerRepo;
	}

	@PostConstruct
	public void setup() {
		try {
			List<Player> players = JsonParser.deserializePlayers(playersPath);
			players.stream().forEach(player -> playerRepo.add(player));

			List<PlayerStats> stats = JsonParser.deserializeStats(statsPath);
			playerRepo.setPlayerStats(stats);

			System.out.println("\nSetup complete. Players count " + players.size() + ".\n");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Separates players into lists depending on their position
	 * @return Map of <Position, List of players> pairs
	 */
	public Map<String, List<Player>> getPlayersByPosition() {
		List<IEntity> entities = playerRepo.getAll();

		List<Player> pg = new ArrayList<>();
		List<Player> sg = new ArrayList<>();
		List<Player> sf = new ArrayList<>();
		List<Player> pf = new ArrayList<>();
		List<Player> c = new ArrayList<>();

		for (IEntity entity : entities) {
			Player player = (Player) entity;

			for (Position position : player.getPositions()) {
				switch (position) {
					case POINT_GUARD:
						pg.add(player);
						break;
					case SHOOTING_GUARD:
						sg.add(player);
						break;
					case SMALL_FORWARD:
						sf.add(player);
						break;
					case POWER_FORWARD:
						pf.add(player);
						break;
					case CENTER:
						c.add(player);
						break;
				}
			}
		}

		Collections.sort(pg, new PlayerNameComparator());
		Collections.sort(sg, new PlayerNameComparator());
		Collections.sort(sf, new PlayerNameComparator());
		Collections.sort(pf, new PlayerNameComparator());
		Collections.sort(c, new PlayerNameComparator());

		Map<String, List<Player>> map = new HashMap<>();
		map.put(Position.POINT_GUARD.toValue(), pg);
		map.put(Position.SHOOTING_GUARD.toValue(), sg);
		map.put(Position.SMALL_FORWARD.toValue(), sf);
		map.put(Position.POWER_FORWARD.toValue(), pf);
		map.put(Position.CENTER.toValue(), c);

		System.out.println("\nPlayers by position (" + entities.size() +"):");
		System.out.println("#" + Position.POINT_GUARD.toValue() + "# " + pg.size());
		System.out.println("#" + Position.SHOOTING_GUARD.toValue() + "# " + sg.size());
		System.out.println("#" + Position.SMALL_FORWARD.toValue() + "# " + pf.size());
		System.out.println("#" + Position.POWER_FORWARD.toValue() + "# " + sf.size());
		System.out.println("#" + Position.CENTER.toValue() + "# " + c.size());

		return map;
	}
}
