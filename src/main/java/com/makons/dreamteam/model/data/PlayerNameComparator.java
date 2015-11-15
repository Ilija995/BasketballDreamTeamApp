package com.makons.dreamteam.model.data;

import com.makons.dreamteam.model.data.entities.Player;

import java.util.Comparator;

public class PlayerNameComparator implements Comparator<Player> {

	public int compare(Player a, Player b) {
		return (a.getFirstName().equals(b.getFirstName())) ? a.getLastName().compareTo(b.getLastName()) : a.getFirstName().compareTo(b.getFirstName());
	}
}
