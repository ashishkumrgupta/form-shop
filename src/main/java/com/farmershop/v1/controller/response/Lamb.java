package com.farmershop.v1.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class Lamb {

	private String name;
	private String sex;
	private String type;
	@JsonProperty("wool")
	private double woolQuanity;
}
