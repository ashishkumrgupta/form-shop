package com.farmershop.initializer.db;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Class to store Lamb details.
 * 
 * @author Ashish
 *
 */
@Getter
@Setter
@ToString
public class Lamb extends Flock {

	private double woolQuanity;

	private Lamb(double woolQuantity) {
		this.woolQuanity = woolQuantity;
	}

	public double getWoolQuanity() {
		return woolQuanity;
	}

	public static class Builder {
		private double woolQuanity;

		public Builder withWoolQuanity(double woolQuanity) {
			this.woolQuanity = woolQuanity;
			return this;
		}

		public Lamb build() {
			return new Lamb(woolQuanity);
		}
	}
}
