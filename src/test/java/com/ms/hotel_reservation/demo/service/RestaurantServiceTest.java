package com.ms.hotel_reservation.demo.service;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.apache.tomcat.util.file.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ms.hotel_reservation.domain.model.Restaurant;
import com.ms.hotel_reservation.domain.repo.InMemRestaurantRepository;
import com.ms.hotel_reservation.domain.service.RestaurantService;

public class RestaurantServiceTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	@Test
	public void testAddRestaurantSuccessful() throws Exception {
		String restuarantId = UUID.randomUUID().toString();
		Restaurant restaurant  = new Restaurant(restuarantId, "UT-001", null);
		RestaurantService service = new RestaurantService(new InMemRestaurantRepository());
		service.add(restaurant);
		assertTrue(service.getAll().contains(restaurant));
	}

	@Test
	public void testGetAll() throws Exception {
		String restuarantId = UUID.randomUUID().toString();
		Restaurant restaurant  = new Restaurant(restuarantId, "UT-001", null);
		Restaurant restaurant2  = new Restaurant(UUID.randomUUID().toString(), "UT-002", null);
		RestaurantService service = new RestaurantService(new InMemRestaurantRepository());
		service.add(restaurant);
		service.add(restaurant2);
		assertTrue(service.getAll().size()==2);
		assertTrue(service.getAll().contains(restaurant));
		assertTrue(service.getAll().contains(restaurant2));
	}

	@Test
	public void testAddRestaurantDuplicate() throws Exception {
		String restuarantId = UUID.randomUUID().toString();
		Restaurant restaurant  = new Restaurant(restuarantId, "UT-001", null);
		expectedException.expect(Exception.class);
		expectedException.expectMessage("Restaurant with name "+ restaurant.getName()+" already exists");
		RestaurantService service = new RestaurantService(new InMemRestaurantRepository());
		service.add(restaurant);
		service.add(restaurant);
		assertTrue(service.getAll().contains(restaurant));
	}
}
