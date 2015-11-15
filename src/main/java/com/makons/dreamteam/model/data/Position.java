package com.makons.dreamteam.model.data;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.*;
import java.util.Map.*;

public enum Position {
	POINT_GUARD,
	SHOOTING_GUARD,
	SMALL_FORWARD,
	POWER_FORWARD,
	CENTER;

	private static Map<String, Position> positionsMap = new HashMap<>(5);

	static {
		positionsMap.put("PG", POINT_GUARD);
		positionsMap.put("SG", SHOOTING_GUARD);
		positionsMap.put("SF", SMALL_FORWARD);
		positionsMap.put("PF", POWER_FORWARD);
		positionsMap.put("C", CENTER);
	}

	@JsonCreator
	public static Position forValue(String value) {
		return positionsMap.get(value.toUpperCase());
	}

	public String toValue() {
		for (Entry<String, Position> entry : positionsMap.entrySet()) {
			if (entry.getValue() == this) {
				return entry.getKey();
			}
		}

		// Failed
		return null;
	}
}
