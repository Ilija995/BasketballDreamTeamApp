package com.makons.dreamteam.model.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Entity implements IEntity {

	private String id;

	@JsonProperty("id")
	protected void setId(String id) {
		this.id = id.trim();
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public int getScore() {
		return 0;
	}
}
