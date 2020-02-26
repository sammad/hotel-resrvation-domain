package com.ms.hotel_reservation.domain.model;

import java.util.List;

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
	
	
}
