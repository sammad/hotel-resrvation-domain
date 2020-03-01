package com.ms.hotel_reservation.domain.model;

import java.util.List;
import java.util.Objects;

public class Restaurant extends BaseEntity<String> {

	private List<Table<String>> tables;
	public Restaurant(String id, String name, List<Table<String>> tables) {
		super(id, name);
		this.tables=tables;
	}
	public List<Table<String>> getTables() {
		return tables;
	}
	public void setTables(List<Table<String>> tables) {
		this.tables = tables;
	}
	@Override
	public String toString() {
		return "Restaurant [tables=" + tables + ", IsModified=" + getIsModified() + ", Id=" + getId()
				+ ", Name=" + getName() + "]";
	}
	
	@Override
	public boolean equals(Object restaurantObj) {
		Boolean result = Boolean.FALSE;
		if(restaurantObj instanceof Restaurant) {
			if(this.getId().equals(((Restaurant)restaurantObj).getId())){
				result=true;
			}
		}
		return result;
	}
	
	public int hashCode() {
		return Objects.hashCode(this.getId());
	}
}
