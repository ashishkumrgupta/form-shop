package com.farmershop.exception;

/**
 * Exception to be thrown in case placed order is more than the stock available.
 * 
 * @author Ashis
 *
 */
public class InsufficientStockException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientStockException(String msg) {
		super(msg);
	}

	public InsufficientStockException() {
		super();
	}

	public InsufficientStockException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}