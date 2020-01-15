package com.farmershop.initializer.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory class to provide requested Flock object at run time.
 * 
 * @author Ashish
 *
 */
public class FlockFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlockFactory.class);

	public static Flock getFlock(String flockType, String sex) {
		Flock result = null;

		if (flockType.equalsIgnoreCase(FlockType.SHEEP.name())) {
			if (FlockSexType.F.name().equalsIgnoreCase(sex)) {
				result = new Sheep.Builder().withMilkQuanity().build();
				setTypeAndSex(result, flockType, sex);
			} else if (FlockSexType.M.name().equalsIgnoreCase(sex)) {
				result = new Sheep.Builder().build();
				setTypeAndSex(result, flockType, sex);
			} else {
				result = null;
			}
		}

		else if (flockType.equalsIgnoreCase(FlockType.GOAT.name())) {
			if (FlockSexType.F.name().equalsIgnoreCase(sex)) {
				result = new Goat.Builder().withMilkQuanity().build();
				setTypeAndSex(result, flockType, sex);
			} else if (FlockSexType.M.name().equalsIgnoreCase(sex)) {
				result = new Goat.Builder().build();
				setTypeAndSex(result, flockType, sex);
			} else {
				result = null;
			}
		}

		else if (flockType.equalsIgnoreCase(FlockType.LAMB.name())) {
			result = new Lamb.Builder().build();
			setTypeAndSex(result, flockType, sex);
		} else {
			LOGGER.error("Requested Flock type is not yet supported.", flockType);
		}
		return result;
	}

	/**
	 * Utility class to set flock type and sex
	 * 
	 * @param flock
	 *            {@link Flock}
	 * @param type
	 *            flock type
	 * @param sex
	 *            fock sex
	 * @return {@link Flock}
	 */
	private static Flock setTypeAndSex(Flock flock, String type, String sex) {
		flock.setFlockType(type);
		flock.setSex(sex);
		return flock;
	}
}
