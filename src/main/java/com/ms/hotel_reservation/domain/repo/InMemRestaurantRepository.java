package com.ms.hotel_reservation.domain.repo;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ms.hotel_reservation.domain.model.Restaurant;

public class InMemRestaurantRepository implements RestaurantRepository {

	private Map<String, Restaurant> restaurantInMemStore;
	
	public InMemRestaurantRepository() {
		restaurantInMemStore = new ConcurrentHashMap<String, Restaurant>();
	}
	@Override
	public void add(Restaurant entity) {
		restaurantInMemStore.put(entity.getId(),entity);
	}

	@Override
	public void update(Restaurant entity) {
		if(this.contains(entity)) {
			this.restaurantInMemStore.put(entity.getId(),entity);
		}
		
	}

	@Override
	public boolean delete(String id) {
		
		return this.restaurantInMemStore.remove(id)!=null;
	}

	@Override
	public Boolean contains(Restaurant entity) {
		return (this.restaurantInMemStore.containsKey(entity.getId()))
				?this.restaurantInMemStore.get(entity.getId()).equals(entity)
				:Boolean.FALSE;
	}

	@Override
	public Restaurant find(String id) {
		return restaurantInMemStore.get(id);
	}

	@Override
	public Collection<Restaurant> getAll() {
		return restaurantInMemStore.values();
	}

	@Override
	public boolean containsName(String name) {
		return restaurantInMemStore.values().stream().anyMatch(restaurant->name.equalsIgnoreCase(restaurant.getName()));
	}

}
