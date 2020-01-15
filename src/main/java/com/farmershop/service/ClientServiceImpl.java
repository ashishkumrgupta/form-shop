package com.farmershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmershop.exception.InsufficientStockException;
import com.farmershop.initializer.FarmShopDataInitializer;
import com.farmershop.initializer.db.FlockDB;
import com.farmershop.initializer.db.OrderDB;
import com.farmershop.service.helper.ClientServiceHelper;
import com.farmershop.v1.controller.requests.OrderRequest;
import com.farmershop.v1.controller.response.GetStocksResponse;
import com.farmershop.v1.controller.response.OrderResponse;

/**
 * Service class for Client requests.
 * 
 * @author Ashish
 *
 */
@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientServiceHelper clientServiceHelper;

	FlockDB source = FarmShopDataInitializer.getFlockDB();

	@Override
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		FlockDB flockDB = FarmShopDataInitializer.getFlockDB();
		OrderDB orderDB = FarmShopDataInitializer.getOrderDB();

		String orderId;
		if (clientServiceHelper.checkStockAvailability(flockDB, orderRequest)) {
			orderId = clientServiceHelper.placeOrder(flockDB, orderRequest);
		} else {
			throw new InsufficientStockException("Requested amount of wool or milk is not available.");
		}
		clientServiceHelper.saveOrder(orderId, orderRequest, orderDB);
		return new OrderResponse(orderId);
	}

	@Override
	public GetStocksResponse viewStock() {
		FlockDB stock = FarmShopDataInitializer.getFlockDB();

		GetStocksResponse response = new GetStocksResponse();
		response.setMilkeQuantity(stock.getTotalMilk());
		response.setWoolQuantity(stock.getTotalWool());

		return response;
	}

}
