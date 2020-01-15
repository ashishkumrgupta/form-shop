package com.farmershop.service.helper;

import org.springframework.stereotype.Component;

import com.farmershop.initializer.db.FlockDB;
import com.farmershop.initializer.db.Order;
import com.farmershop.initializer.db.OrderDB;
import com.farmershop.initializer.db.OrderHistory;
import com.farmershop.v1.controller.requests.OrderRequest;

/**
 * Helper Methods for Client Service.
 * 
 * @author Ashish
 *
 */
@Component
public class ClientServiceHelper {

	/**
	 * Random order Id to start with.
	 */
	private long orderId = 32176L;

	/**
	 * To find if the ordered quantity is available in the stock.
	 * 
	 * @param stock        {@link FlockDB}
	 * @param orderRequest {@link OrderRequest}
	 * @return true is ordered quantity is available.
	 */
	public boolean checkStockAvailability(FlockDB stock, OrderRequest orderRequest) {
		double milkOrder = orderRequest.getOrder().getMilk();
		double woolOrder = orderRequest.getOrder().getWool();
		boolean response = true;

		if (stock.getTotalMilk() < milkOrder || stock.getTotalWool() < woolOrder)
			response = false;
		return response;
	}

	/**
	 * To place an order.
	 * 
	 * @param stock        {@link FlockDB}
	 * @param orderRequest {@link OrderRequest}
	 * @return orderid of the order.
	 */
	public String placeOrder(FlockDB stock, OrderRequest orderRequest) {
		double milkOrder = orderRequest.getOrder().getMilk();
		double woolOrder = orderRequest.getOrder().getWool();
		stock.setTotalMilk(stock.getTotalMilk() - milkOrder);
		stock.setTotalWool(stock.getTotalWool() - woolOrder);

		return Long.toString(orderId++);
	}

	/**
	 * To save a placed order.
	 * 
	 * @param orderId      orderId of the Order.
	 * @param orderDB      {@link OrderDB}
	 * @param orderRequest {@link OrderRequest}
	 */
	public void saveOrder(String orderId, OrderRequest orderRequest, OrderDB orderDB) {
		Order order = new Order(orderRequest.getOrder().getMilk(), orderRequest.getOrder().getWool());
		OrderHistory history = new OrderHistory(orderId, orderRequest.getCustomerName(), order);
		orderDB.getOrderHistories().add(history);
	}
}
