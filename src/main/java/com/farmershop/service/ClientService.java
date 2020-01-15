package com.farmershop.service;

import com.farmershop.v1.controller.requests.OrderRequest;
import com.farmershop.v1.controller.response.GetStocksResponse;
import com.farmershop.v1.controller.response.OrderResponse;

/**
 * Service for client related requests.
 * 
 * @author Ashish
 *
 */
public interface ClientService {

	/**
	 * To order milk or/and wool.
	 * 
	 * @param orderRequest
	 *            {@link OrderRequest}
	 * @return {@link OrderResponse} of the order.
	 */
	public OrderResponse placeOrder(OrderRequest orderRequest);

	/**
	 * to see what stock of milk and wool is available.
	 * 
	 * @return {@link GetStocksResponse}
	 */
	public GetStocksResponse viewStock();
}
