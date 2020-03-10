package com.ms.hotel_reservation.domain.service;

import java.util.Collection;

import com.ms.hotel_reservation.domain.model.Restaurant;
import com.ms.hotel_reservation.domain.repo.RestaurantRepository;

public class RestaurantService extends BaseService<Restaurant, String> {

	private RestaurantRepository repository;
	public RestaurantService(RestaurantRepository repo) {
		super(repo);
		this.repository=repo;
	}
	@Override
	public void add(Restaurant entity) throws Exception {
		if(repository.containsName(entity.getName())) {
			throw new Exception("Restaurant with name "+ entity.getName()+" already exists");
		}else if(repository.find(entity.getId())!=null) {
			throw new Exception("Restaurant id:"+ entity.getId()+" name:"+entity.getName()+" already exists");
		}
		super.add(entity);
	}
	@Override
	public Collection<Restaurant> getAll() {
		return super.getAll();
	}
	
}
