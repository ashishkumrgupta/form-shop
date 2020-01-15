package com.farmershop.initializer.db;

import lombok.Getter;
import lombok.ToString;

/**
 * Class to store Goat details.
 * 
 * @author Ashish
 *
 */
@Getter
@ToString
public class Goat extends Flock {
	private double milkQuantity;

	private Goat(double milkQuantity) {
		super();
		this.milkQuantity = milkQuantity;
	}

	public double getMilkQuantity() {
		return milkQuantity;
	}

	public static class Builder {

		private double milkQuantity;

		public Builder withMilkQuanity() {
			this.milkQuantity = 50.0;
			return this;
		}

		public Goat build() {
			return new Goat(milkQuantity);
		}
	}
}
