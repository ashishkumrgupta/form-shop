package com.farmershop.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.farmershop.initializer.db.Order;
import com.farmershop.initializer.db.OrderDB;
import com.farmershop.initializer.db.OrderHistory;
import com.farmershop.v1.controller.response.GetOrderHistoryResponse;

@RunWith(SpringRunner.class)
public class OrderHistoryMapperTest {

	private static List<OrderHistory> orderHistory;

	@BeforeClass
	public static void init() {
		orderHistory = new ArrayList<>();
		OrderHistory history = new OrderHistory("testOrderId", "TestCustomerName", new Order(10.00, 10.00));
		orderHistory.add(history);
	}

	@InjectMocks
	private OrderHistoryMapper unitToTest = new OrderHistoryMapper();

	@Mock
	private OrderDB orderDB;

	@Test
	public void OrderHistoryMapper_NoOrders_test() {
		GetOrderHistoryResponse result = new GetOrderHistoryResponse();
		result = unitToTest.mapOrderHistory(orderDB, result);
		assertNotNull(result);
	}

	@Test
	public void OrderHistoryMapper_test() {
		GetOrderHistoryResponse result = new GetOrderHistoryResponse();

		when(orderDB.getOrderHistories()).thenReturn(orderHistory);
		result = unitToTest.mapOrderHistory(orderDB, result);
		assertEquals(1, result.getOrderHistory().size());

		assertEquals("testOrderId", result.getOrderHistory().get(0).getOrderId());
		assertEquals("TestCustomerName", result.getOrderHistory().get(0).getCustomerName());
	}

}
