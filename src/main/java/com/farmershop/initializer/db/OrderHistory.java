package com.farmershop.initializer.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DB Class to store the Order history.
 * 
 * @author Ashish
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderHistory {
	private String orderId;
	private String customerName;
	private Order order;
}
