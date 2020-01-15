package com.farmershop.v1.controller.requests;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;

/**
 * Order details requests
 * 
 * @author Ashish
 *
 */
@Getter
@JsonRootName("order")
public class Order {
	private double milk;
	private double wool;
}
