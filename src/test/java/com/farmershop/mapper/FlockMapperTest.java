package com.farmershop.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.farmershop.initializer.db.FlockDB;
import com.farmershop.initializer.db.FlockFactory;
import com.farmershop.initializer.db.Goat;
import com.farmershop.initializer.db.Lamb;
import com.farmershop.initializer.db.Sheep;
import com.farmershop.v1.controller.response.GetAvailableFlocksResponse;

@RunWith(SpringRunner.class)
public class FlockMapperTest {

	private List<Goat> goats;
	private List<Lamb> lambs;
	private List<Sheep> sheeps;
	private List<com.farmershop.v1.controller.response.Goat> expectedGoats;
	private List<com.farmershop.v1.controller.response.Sheep> expectedSheeps;
	private List<com.farmershop.v1.controller.response.Lamb> expectedLambs;

	@Before
	public void init() {
		expectedGoats = new ArrayList<>();
		expectedSheeps = new ArrayList<>();
		expectedLambs = new ArrayList<>();

		com.farmershop.v1.controller.response.Goat expectedGoat = new com.farmershop.v1.controller.response.Goat();
		expectedGoat.setName("testGoat");
		expectedGoat.setSex("M");
		expectedGoat.setType("GOAT");
		expectedGoats.add(expectedGoat);

		com.farmershop.v1.controller.response.Sheep expectedSheep = new com.farmershop.v1.controller.response.Sheep();
		expectedSheep.setName("testSheep");
		expectedSheep.setSex("M");
		expectedSheep.setType("SHEEP");
		expectedSheep.setWoolQuanity(10);
		expectedSheeps.add(expectedSheep);

		com.farmershop.v1.controller.response.Lamb expectedLamb = new com.farmershop.v1.controller.response.Lamb();
		expectedLamb.setName("testLamb");
		expectedLamb.setSex("F");
		expectedLamb.setType("LAMB");
		expectedLamb.setWoolQuanity(10);
		expectedLambs.add(expectedLamb);

		Goat goat = (Goat) FlockFactory.getFlock("GOAT", "M");
		goat.setName("testGoat");

		Sheep sheep = (Sheep) FlockFactory.getFlock("SHEEP", "M");
		sheep.setName("testSheep");
		sheep.setWoolQuanity(10.00);

		Lamb lamb = (Lamb) FlockFactory.getFlock("LAMB", "F");
		lamb.setName("testLamb");
		lamb.setWoolQuanity(10.00);

		goats = new ArrayList<>();
		goats.add(goat);
		lambs = new ArrayList<>();
		lambs.add(lamb);
		sheeps = new ArrayList<>();
		sheeps.add(sheep);
	}

	@InjectMocks
	private FlockMapper unitTest = new FlockMapper();

	@Mock
	private FlockDB source;

	@Test
	public void mapFlock_test() {
		GetAvailableFlocksResponse result = new GetAvailableFlocksResponse();

		when(source.getGoats()).thenReturn(goats);
		when(source.getLambs()).thenReturn(lambs);
		when(source.getSheeps()).thenReturn(sheeps);

		result = unitTest.mapFlock(source, result);

		assertEquals(expectedGoats.size(), result.getGoat().size());
		assertEquals(expectedLambs.size(), result.getLamb().size());
		assertEquals(expectedSheeps.size(), result.getSheep().size());
		assertThat(expectedGoats.get(0)).isEqualToComparingFieldByField(result.getGoat().get(0));
		assertThat(expectedSheeps.get(0)).isEqualToComparingFieldByField(result.getSheep().get(0));
		assertThat(expectedLambs.get(0)).isEqualToComparingFieldByField(result.getLamb().get(0));
	}
}
