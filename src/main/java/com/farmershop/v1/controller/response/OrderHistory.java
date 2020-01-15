package com.farmershop.v1.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response class for Order History.
 * 
 * @author Ashish
 *
 */
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class OrderHistory {
	@JsonIgnore
	private String orderId;
	@JsonProperty(value = "customer")
	private String customerName;
	private Order order;
}
