package com.farmershop.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.farmershop.initializer.db.FlockDB;
import com.farmershop.v1.controller.response.GetAvailableFlocksResponse;
import com.farmershop.v1.controller.response.Goat;
import com.farmershop.v1.controller.response.Lamb;
import com.farmershop.v1.controller.response.Sheep;

/**
 * Utility class to map Flock database objects with flock response objects.
 * 
 * @author Ashish
 *
 */
@Component
public class FlockMapper {

	/**
	 * To map {@link FlockDB} object with {@link GetAvailableFlocksResponse}
	 * 
	 * @param source
	 *            {@link FlockDB}
	 * @param result
	 *            {@link GetAvailableFlocksResponse}
	 * @return {@link GetAvailableFlocksResponse}
	 */
	public GetAvailableFlocksResponse mapFlock(FlockDB source, GetAvailableFlocksResponse result) {

		result.setGoat(mapGoat(source.getGoats(), new ArrayList<>()));
		result.setLamb(mapLamb(source.getLambs(), new ArrayList<>()));
		result.setSheep(mapSheep(source.getSheeps(), new ArrayList<>()));
		return result;
	}

	/**
	 * To map {@link com.thymeleaf.demo.initializer.db.Goat} with {@link Goat}
	 * 
	 * @param source
	 *            {@link com.thymeleaf.demo.initializer.db.Goat}
	 * @param result
	 *            {@link Goat}
	 * @return {@link Goat}
	 */
	private List<Goat> mapGoat(List<com.farmershop.initializer.db.Goat> source, List<Goat> result) {
		source.forEach(sourceGoat -> {
			Goat target = new Goat();
			target.setName(sourceGoat.getName());
			target.setSex(sourceGoat.getSex());
			target.setType(sourceGoat.getFlockType());
			target.setMilkQuantity(sourceGoat.getMilkQuantity());
			result.add(target);
		});
		return result;
	}

	/**
	 * To Map {@link com.thymeleaf.demo.initializer.db.Sheep} with {@link Sheep}
	 * 
	 * @param source
	 *            {@link com.thymeleaf.demo.initializer.db.Sheep}
	 * @param result
	 *            {@link Sheep}
	 * @return {@link Sheep}
	 */
	private List<Sheep> mapSheep(List<com.farmershop.initializer.db.Sheep> source, List<Sheep> result) {
		source.forEach(sourceSheep -> {
			Sheep target = new Sheep();
			target.setMilkQuantity(sourceSheep.getMilkQuantity());
			target.setWoolQuanity(sourceSheep.getWoolQuanity());
			target.setName(sourceSheep.getName());
			target.setSex(sourceSheep.getSex());
			target.setType(sourceSheep.getFlockType());
			result.add(target);
		});
		return result;
	}

	/**
	 * To map {@link com.thymeleaf.demo.initializer.db.Lamb} with {@link Lamb}
	 * 
	 * @param source
	 *            {@link com.thymeleaf.demo.initializer.db.Lamb}
	 * @param result
	 *            {@link Lamb}
	 * @return {@link Lamb}
	 */
	private List<Lamb> mapLamb(List<com.farmershop.initializer.db.Lamb> source, List<Lamb> result) {
		source.forEach(sourceLamb -> {
			Lamb target = new Lamb();
			target.setName(sourceLamb.getName());
			target.setSex(sourceLamb.getSex());
			target.setType(sourceLamb.getFlockType());
			target.setWoolQuanity(sourceLamb.getWoolQuanity());
			result.add(target);
		});
		return result;
	}

}
