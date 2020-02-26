package com.ms.hotel_reservation.domain.model;

public class Table<T> extends BaseEntity<T> {

	private Integer capacity;

	public Table(T id,String name,Integer capacity) {
		super(id,name);
		this.capacity = capacity;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Table [capacity=" + capacity + ", isModified=" + getIsModified() + ", Id=" + getId()
				+ ", name=" + getName() + "]";
	}
	
	
	
}
