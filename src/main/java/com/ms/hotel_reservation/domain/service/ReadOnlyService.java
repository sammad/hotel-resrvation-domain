package com.ms.hotel_reservation.domain.service;

import com.ms.hotel_reservation.domain.repo.Repository;

public abstract class ReadOnlyService<ET, T> {

	private Repository<ET, T> _repository;
	public ReadOnlyService(Repository<ET, T> repo) {
	   _repository = repo;
	}
}
