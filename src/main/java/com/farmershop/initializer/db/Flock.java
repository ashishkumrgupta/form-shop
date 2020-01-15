package com.farmershop.initializer.db;

/**
 * Class to store Flock details.
 * 
 * @author Ashish
 *
 */
public abstract class Flock {

	private String sex;

	private String name;

	private String flockType;

	public Flock() {
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlockType() {
		return flockType;
	}

	public void setFlockType(String flockType) {
		this.flockType = flockType;
	}
}
