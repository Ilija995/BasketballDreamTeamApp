package com.makons.dreamteam.controllers;

import com.makons.dreamteam.model.data.entities.User;
import com.makons.dreamteam.services.DreamTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MyDreamTeamsController {

	private DreamTeamService dreamTeamService;

	@Autowired
	public MyDreamTeamsController(DreamTeamService dreamTeamService) {
		this.dreamTeamService = dreamTeamService;
	}

	@RequestMapping(value = "/myDreamTeams", method = RequestMethod.GET)
	public String myDreamTeams(Model model) {
		model.addAttribute("dreamTeams", dreamTeamService.getDreamTeams());

		return "myDreamTeams";
	}

	@RequestMapping(value = "/myDreamTeams", method = RequestMethod.POST)
	public String chooseDreamTeam(@RequestParam("pgId") String pgId,
								  @RequestParam("sgId") String sgId,
								  @RequestParam("sfId") String sfId,
								  @RequestParam("pfId") String pfId,
								  @RequestParam("cId") String cId,
								  @RequestParam("teamName") String teamName,
								  Model model) {
		model.addAttribute("dreamTeams", dreamTeamService.setDreamTeam(pgId, sgId, sfId, pfId, cId, teamName));

		return "myDreamTeams";
	}
}
