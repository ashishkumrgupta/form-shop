package com.farmershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmershop.initializer.FarmShopDataInitializer;
import com.farmershop.initializer.db.FlockDB;
import com.farmershop.initializer.db.OrderDB;
import com.farmershop.mapper.FlockMapper;
import com.farmershop.mapper.OrderHistoryMapper;
import com.farmershop.v1.controller.response.GetAvailableFlocksResponse;
import com.farmershop.v1.controller.response.GetOrderHistoryResponse;

/**
 * Service class for Farmer requests.
 * 
 * @author Ashis
 *
 */
@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	private FlockMapper flockMapper;

	@Autowired
	private OrderHistoryMapper orderHistoryMapper;

	@Override
	public GetAvailableFlocksResponse getAvailableFlocks() {
		FlockDB source = FarmShopDataInitializer.getFlockDB();

		GetAvailableFlocksResponse response = new GetAvailableFlocksResponse();
		flockMapper.mapFlock(source, response);
		return response;
	}

	@Override
	public GetOrderHistoryResponse getOrderHistory() {
		OrderDB orderDB = FarmShopDataInitializer.getOrderDB();

		GetOrderHistoryResponse getOrderHistoryResponse = new GetOrderHistoryResponse();
		return orderHistoryMapper.mapOrderHistory(orderDB, getOrderHistoryResponse);
	}

}
