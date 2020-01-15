package com.farmershop.initializer.db;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Order details requests
 * 
 * @author Ashish
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonRootName("order")
public class Order {
	private double milk;
	private double wool;
}
