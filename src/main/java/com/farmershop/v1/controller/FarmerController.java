package com.farmershop.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmershop.service.FarmerService;
import com.farmershop.v1.controller.response.GetAvailableFlocksResponse;
import com.farmershop.v1.controller.response.GetOrderHistoryResponse;

/**
 * Controller for admin related requests.
 * 
 * @author Ashish
 *
 */
@RestController
@RequestMapping("/farmshop/admin")
public class FarmerController {

	@Autowired
	private FarmerService farmerService;

	@GetMapping("/flocks")
	public ResponseEntity<GetAvailableFlocksResponse> getFlocks() {
		return new ResponseEntity<>(farmerService.getAvailableFlocks(), HttpStatus.OK);
	}

	@GetMapping("/orders")
	public ResponseEntity<GetOrderHistoryResponse> getOrdersHistory() {
		return new ResponseEntity<>(farmerService.getOrderHistory(), HttpStatus.OK);
	}
}
