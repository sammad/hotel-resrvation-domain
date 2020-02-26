package com.ms.hotel_reservation.domain.model;

public interface Repository<ET, T> extends ReadOnlyRepository<ET, T> {

	public void add(ET entity);
	public void update(ET entity);
	public boolean delete(T id);
}
