package com.farmershop.v1.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor

public class Sheep {

	private String name;
	private String sex;
	private double woolQuanity;
	private String type;
	@JsonIgnore
	private double milkQuantity;
}