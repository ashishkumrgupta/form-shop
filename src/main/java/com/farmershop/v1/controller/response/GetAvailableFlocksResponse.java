package com.farmershop.v1.controller.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonRootName(value = "flock")
public class GetAvailableFlocksResponse {
	private List<Goat> goat;
	private List<Sheep> sheep;
	private List<Lamb> lamb;

}
