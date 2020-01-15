package com.farmershop.v1.controller.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Response Object works as a wrapper for Order History.
 * 
 * @author Ashis
 *
 */
@Setter
@Getter
public class GetOrderHistoryResponse {
	private List<OrderHistory> orderHistory;

	public GetOrderHistoryResponse() {
		this.orderHistory = new ArrayList<>();
	}
}
