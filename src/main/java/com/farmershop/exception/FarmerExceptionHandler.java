package com.farmershop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.farmershop.v1.controller.response.FarmerExceptionResponse;

/**
 * Class to centrally handle Application related exception
 * 
 * @author Ashish
 *
 */
@ControllerAdvice
public class FarmerExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { InsufficientStockException.class })
	protected ResponseEntity<Object> handleInsuffiecientStockException(RuntimeException ex, WebRequest request) {
		FarmerExceptionResponse response = new FarmerExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
