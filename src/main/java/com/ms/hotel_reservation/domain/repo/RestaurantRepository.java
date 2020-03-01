package com.ms.hotel_reservation.domain.repo;

import com.ms.hotel_reservation.domain.model.Restaurant;

public interface RestaurantRepository extends Repository<Restaurant, String> {

	public boolean containsName(String name);
}
