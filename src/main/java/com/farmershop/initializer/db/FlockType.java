package com.farmershop.initializer.db;

/**
 * Available Flock Type.
 * 
 * @author Ashish
 *
 */
public enum FlockType {
	SHEEP("sheep"), GOAT("goat"), LAMB("lamb");

	private String type;

	FlockType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
