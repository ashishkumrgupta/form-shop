package com.farmershop.v1.controller.requests;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

/**
 * Request to place an order.
 * 
 * @author Ashish
 *
 */
@Getter
public class OrderRequest {
	@JsonProperty(value = "customer")
	private String customerName;
	private Order order;
}