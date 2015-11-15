package com.makons.dreamteam.model.repo;

import com.makons.dreamteam.model.data.entities.IEntity;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Repo implements IRepo {

	/**
	 * Map of our entities in this repository.
	 * Maps entity IDs with entities.
	 */
	protected Map<String, IEntity> entityMap = new HashMap<>();

	/**
	 * Add new entity
	 * @param entity New entity
	 */
	@Override
	public void add(IEntity entity) {
		entityMap.put(entity.getId(), entity);
	}

	/**
	 * Update existing entity
	 * @param entity Entity that is updated
	 */
	@Override
	public void update(IEntity entity) {
		throw new NotImplementedException();
	}

	/**
	 * Delete an entity from repository
	 * @param entity Entity which is deleted
	 */
	@Override
	public void delete(IEntity entity) {
		entityMap.remove(entity.getId());
	}

	/**
	 * Retrieves entity from repository
	 * @param id ID of requested entity
	 * @return Entity with requested ID
	 */
	@Override
	public IEntity get(String id) {
		if (entityMap == null) {
			return null;
		}

		return entityMap.get(id);
	}

	/**
	 * Retrieves all entities from repository
	 * @return List of all entities
	 */
	@Override
	public List<IEntity> getAll() {
		if (entityMap == null) {
			return new ArrayList<>();
		}

		return new ArrayList<>(entityMap.values());
	}
}
