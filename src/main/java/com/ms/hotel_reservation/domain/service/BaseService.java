package com.ms.hotel_reservation.domain.service;

import java.util.Collection;

import com.ms.hotel_reservation.domain.repo.Repository;

public class BaseService<ET, T> extends ReadOnlyService<ET, T> {

	private Repository<ET, T> repository;
	public BaseService(Repository<ET, T> repo) {
		super(repo);
		this.repository=repo;
	}

	public void add(ET entity) throws Exception {
		repository.add(entity);
	}
	
	public Collection<ET> getAll(){
		return repository.getAll();
	}
}

