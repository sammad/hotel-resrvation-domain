package com.ms.hotel_reservation.demo.repo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

import com.ms.hotel_reservation.domain.model.Restaurant;
import com.ms.hotel_reservation.domain.model.Table;
import com.ms.hotel_reservation.domain.repo.InMemRestaurantRepository;
import com.ms.hotel_reservation.domain.repo.RestaurantRepository;

public class InMemoryRestaurantRepoTest {

	@Test
	public void testAdd() {
		String restId="RestaurantAdd001";
		Restaurant restaurant = new Restaurant(restId, "Restaurant-UT01", null);
		RestaurantRepository restaurantRepository = new InMemRestaurantRepository();
		restaurantRepository.add(restaurant);
		assertTrue(restaurantRepository.containsName("Restaurant-UT01"));
		assertTrue(restaurantRepository.find(restId).equals(restaurant));
	}

	@Test
	public void testUpdate() {
		String restId="RestaurantAdd001";
		Restaurant restaurant = new Restaurant(restId, "Restaurant-UT01", null);
		RestaurantRepository restaurantRepository = new InMemRestaurantRepository();
		restaurantRepository.add(restaurant);
		assertTrue(restaurantRepository.containsName("Restaurant-UT01"));
		Restaurant restaurantToBeUpdated = restaurantRepository.find(restId);
		assertTrue(restaurantToBeUpdated.equals(restaurant));
		assertTrue(restaurantToBeUpdated.getTables()==null);
		Table<String> table001=new Table<String>("T001", "Table-001", 4);
		restaurantToBeUpdated.setTables(Arrays.asList(new Table[] {table001}));
		restaurantRepository.update(restaurantToBeUpdated);
		Restaurant restaurantUpdated = restaurantRepository.find(restId);
		assertTrue(restaurantUpdated.equals(restaurant));
		assertTrue(restaurantUpdated.getTables()!=null 
				   && restaurantToBeUpdated.getTables().size()==1 );
		assertTrue(restaurantUpdated.getTables().get(0).equals(table001) );
		
	}

	@Test
	public void testDelete() {
		String restId="RestaurantAdd001";
		Restaurant restaurant = new Restaurant(restId, "Restaurant-UT01", null);
		RestaurantRepository restaurantRepository = new InMemRestaurantRepository();
		restaurantRepository.add(restaurant);
		assertTrue(restaurantRepository.contains(restaurant));
		assertTrue(restaurantRepository.find(restId).equals(restaurant));
		restaurantRepository.delete(restId);
		assertTrue(!restaurantRepository.contains(restaurant));
	}

	@Test
	public void testContains() {
		String restId="RestaurantAdd001";
		Restaurant restaurant = new Restaurant(restId, "Restaurant-UT01", null);
		RestaurantRepository restaurantRepository = new InMemRestaurantRepository();
		restaurantRepository.add(restaurant);
		assertTrue(restaurantRepository.contains(restaurant));
	}

	@Test
	public void testFind() {
		String restId="RestaurantAdd001";
		Restaurant restaurant = new Restaurant(restId, "Restaurant-UT01", null);
		RestaurantRepository restaurantRepository = new InMemRestaurantRepository();
		restaurantRepository.add(restaurant);
		assertTrue(restaurantRepository.find(restId).equals(restaurant));
	}

	@Test
	public void testGetAll() {
		String restId="RestaurantAdd001";
		Table<String> table001=new Table<String>("T001", "Table-001", 4);
		Restaurant restaurant = new Restaurant(restId, "Restaurant-UT01", Arrays.asList(new Table[] {table001}));
		RestaurantRepository restaurantRepository = new InMemRestaurantRepository();
		restaurantRepository.add(restaurant);
		assertTrue(table001.equals(restaurantRepository.find(restId).getTables().get(0)));
	}

	@Test
	public void testContainsName() {
		String restId="RestaurantAdd001";
		Restaurant restaurant = new Restaurant(restId, "Restaurant-UT01", null);
		RestaurantRepository restaurantRepository = new InMemRestaurantRepository();
		restaurantRepository.add(restaurant);
		assertTrue(restaurantRepository.contains(restaurant));
		assertTrue(restaurantRepository.containsName("Restaurant-UT01"));
	}

}
