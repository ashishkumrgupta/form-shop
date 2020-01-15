package com.farmershop.v1.controller.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response DTO in case of Exceptions.
 * 
 * @author Ashish
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class FarmerExceptionResponse {

	private String errorMsg;
	private HttpStatus httpStatus;
	private LocalDateTime exceptionTime;

	/**
	 * @param errorMsg
	 *            user friendly message to be sent.
	 * @param httpStatus
	 *            {@link HttpStatus}
	 */
	public FarmerExceptionResponse(String errorMsg, HttpStatus httpStatus) {
		super();
		this.errorMsg = errorMsg;
		this.httpStatus = httpStatus;
		this.exceptionTime = LocalDateTime.now();
	}

}
