package com.farmershop.initializer.db;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * In memory database to store list of orders.
 * 
 * @author Ashish
 *
 */

@Getter
public class OrderDB {
	private List<OrderHistory> orderHistories;

	public OrderDB() {
		this.orderHistories = new ArrayList<OrderHistory>();
	}
}
