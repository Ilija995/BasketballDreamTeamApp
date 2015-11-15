package com.makons.dreamteam.controllers;

import com.makons.dreamteam.model.data.Position;
import com.makons.dreamteam.model.data.entities.Player;
import com.makons.dreamteam.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class NewDreamTeamController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping("/NewDreamTeam")
	public String newDreamTeam(Model model) {
		Map<String, List<Player>> sortedPlayers = playerService.getPlayersByPosition();
		model.addAllAttributes(sortedPlayers);

		return "newDreamTeam";
	}
}
