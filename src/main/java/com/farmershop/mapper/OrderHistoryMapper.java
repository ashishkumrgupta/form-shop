package com.farmershop.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.farmershop.initializer.db.OrderDB;
import com.farmershop.initializer.db.OrderHistory;
import com.farmershop.v1.controller.response.GetOrderHistoryResponse;
import com.farmershop.v1.controller.response.Order;

/**
 * Utility class to map {@link OrderHistory} with
 * {@link GetOrderHistoryResponse}
 * 
 * @author Ashis
 *
 */
@Component
public class OrderHistoryMapper {

	/**
	 * Method to map {@link OrderDB} object with {@link GetOrderHistoryResponse}
	 * 
	 * @param source
	 *            {@link OrderDB}
	 * @param result
	 *            {@link GetOrderHistoryResponse}
	 * @return {@link GetOrderHistoryResponse}
	 */
	public GetOrderHistoryResponse mapOrderHistory(OrderDB source, GetOrderHistoryResponse result) {
		List<OrderHistory> orderHistories = source.getOrderHistories();

		List<com.farmershop.v1.controller.response.OrderHistory> orderHistoryResponse = new ArrayList<>();
		orderHistories.forEach(order -> {
			com.farmershop.v1.controller.response.OrderHistory orderHistory = mapOrderHistory(order,
					new com.farmershop.v1.controller.response.OrderHistory());

			orderHistoryResponse.add(orderHistory);
		});
		result.getOrderHistory().addAll(orderHistoryResponse);
		return result;
	}

	/**
	 * @param source
	 *            {@link OrderHistory}
	 * @param result
	 *            {@link com.thymeleaf.demo.v1.controller.response.OrderHistory}
	 * @return {@link com.thymeleaf.demo.v1.controller.response.OrderHistory}
	 */
	private com.farmershop.v1.controller.response.OrderHistory mapOrderHistory(OrderHistory source,
			com.farmershop.v1.controller.response.OrderHistory result) {
		result.setCustomerName(source.getCustomerName());
		result.setOrderId(source.getOrderId());
		result.setOrder(mapOrder(source.getOrder(), new Order()));
		return result;
	}

	/**
	 * Method to map {@link com.thymeleaf.demo.initializer.db.Order} object with
	 * {@link Order} object
	 * 
	 * @param source
	 *            {@link com.thymeleaf.demo.initializer.db.Order}
	 * @param result
	 * @return {@link Order}
	 */
	private Order mapOrder(com.farmershop.initializer.db.Order source, Order result) {
		result.setMilk(source.getMilk());
		result.setWool(source.getWool());
		return result;
	}

}
