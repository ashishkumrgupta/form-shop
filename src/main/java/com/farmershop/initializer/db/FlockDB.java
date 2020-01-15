package com.farmershop.initializer.db;

import java.util.List;

import lombok.Getter;

/**
 * In memory database to store flock details.
 * 
 * @author Ashish
 *
 */
@Getter
public class FlockDB {

	private List<Sheep> sheeps;
	private List<Goat> goats;
	private List<Lamb> lambs;
	private double totalMilk;
	private double totalWool;

	public FlockDB(List<Sheep> sheeps, List<Goat> goats, List<Lamb> lambs) {
		super();
		this.sheeps = sheeps;
		this.goats = goats;
		this.lambs = lambs;
	}

	public void setTotalMilk(double totalMilk) {
		this.totalMilk = totalMilk;
	}

	public void setTotalWool(double totalWool) {
		this.totalWool = totalWool;
	}

}
