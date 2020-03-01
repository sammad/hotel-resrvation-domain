package com.ms.hotel_reservation.domain.model;

import java.util.Objects;

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
	
	@Override
	public boolean equals(Object tableObj) {
		Boolean result = Boolean.FALSE;
		if(tableObj instanceof Table) {
			if(this.getId().equals(((Table<T>)tableObj).getId())){
				result=true;
			}
		}
		return result;
	}
	
	public int hashCode() {
		return Objects.hashCode(this.getId());
	}
	
}
