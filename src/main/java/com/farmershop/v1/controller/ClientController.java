package com.farmershop.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmershop.service.ClientService;
import com.farmershop.v1.controller.requests.OrderRequest;
import com.farmershop.v1.controller.response.GetStocksResponse;
import com.farmershop.v1.controller.response.OrderResponse;

/**
 * Controller for Client related requests.
 * 
 * @author Ashish
 *
 */
@RestController
@RequestMapping("/farmshop/client/")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping("/order")
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest placeOrderRequest) {
		return new ResponseEntity<>(clientService.placeOrder(placeOrderRequest), HttpStatus.OK);
	}

	@GetMapping("/stocks")
	public ResponseEntity<GetStocksResponse> getStocks() {
		return new ResponseEntity<>(clientService.viewStock(), HttpStatus.OK);
	}

}
