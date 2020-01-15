package com.farmershop.service;

import com.farmershop.v1.controller.response.GetAvailableFlocksResponse;
import com.farmershop.v1.controller.response.GetOrderHistoryResponse;

/**
 * Service for Admin related requests.
 * 
 * @author Ashish
 *
 */
public interface FarmerService {

	/**
	 * To get overview of available flock.
	 * 
	 * @return {@link GetAvailableFlocksResponse}
	 */
	public GetAvailableFlocksResponse getAvailableFlocks();

	/**
	 * To get history of (fulfilled) orders
	 * 
	 * @return {@link GetOrderHistoryResponse}
	 */
	public GetOrderHistoryResponse getOrderHistory();
}
