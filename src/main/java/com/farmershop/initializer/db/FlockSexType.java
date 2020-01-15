package com.farmershop.initializer.db;

/**
 * Supported Sex type of Flocks
 * 
 * @author Ashish
 *
 */
public enum FlockSexType {
	M("m"), F("f");

	/**
	 * @param type
	 */
	private FlockSexType(String type) {
		this.type = type;
	}

	private String type;

	public String getType() {
		return type;
	}

}
