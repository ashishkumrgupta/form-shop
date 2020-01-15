package com.farmershop.v1.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response Object for Get available Stocks.
 * 
 * @author Ashish
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "stocks")
public class GetStocksResponse {

	@JsonProperty(value = "milk")
	private double milkeQuantity;

	@JsonProperty(value = "wool")
	private double woolQuantity;
}
