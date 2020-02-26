package com.ms.hotel_reservation.domain.model;

public abstract class BaseEntity<T> extends Entity<T> {

	private Boolean isModified;

	public BaseEntity(T id, String name) {
		super(id,name);
		isModified=Boolean.FALSE;
	}

	public Boolean getIsModified() {
		return isModified;
	}

	public void setIsModified(Boolean isModified) {
		this.isModified = isModified;
	}
	
}
