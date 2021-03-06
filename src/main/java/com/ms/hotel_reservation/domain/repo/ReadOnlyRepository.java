package com.ms.hotel_reservation.domain.repo;

import java.util.Collection;

public interface ReadOnlyRepository<ET,T> {

	public Boolean contains(ET entity);
	public ET find(T id);
	public Collection<ET> getAll();
}
