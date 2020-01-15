package com.farmershop.initializer.db;

import lombok.Getter;
import lombok.ToString;

/**
 * Class to store Sheep details.
 * 
 * @author Ashis
 *
 */
@Getter
@ToString
public class Sheep extends Flock {

	private double woolQuanity;
	private double milkQuantity;

	public void setWoolQuanity(double woolQuanity) {
		this.woolQuanity = woolQuanity;
	}

	private Sheep(double woolQuanity, double milkQuantity) {
		super();
		this.woolQuanity = woolQuanity;
		this.milkQuantity = milkQuantity;
	}

	public static class Builder {

		private double woolQuanity;
		private double milkQuantity;

		public Builder withWoolQuanity(double woolQuantity) {
			this.woolQuanity = woolQuantity;
			return this;
		}

		public Builder withMilkQuanity() {
			this.milkQuantity = 30.0;
			return this;
		}

		public Sheep build() {
			return new Sheep(woolQuanity, milkQuantity);
		}
	}
}
