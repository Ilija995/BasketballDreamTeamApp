package com.makons.dreamteam.model.repo;

import com.makons.dreamteam.model.data.entities.IEntity;

import java.util.List;

public interface IRepo {

	void add(IEntity entity);

	void update(IEntity entity);

	void delete(IEntity entity);

	IEntity get(String id);

	List<IEntity> getAll();
}
