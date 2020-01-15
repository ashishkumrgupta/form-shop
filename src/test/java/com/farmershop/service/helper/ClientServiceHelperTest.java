package com.farmershop.service.helper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.farmershop.initializer.db.FlockDB;
import com.farmershop.v1.controller.requests.Order;
import com.farmershop.v1.controller.requests.OrderRequest;

@RunWith(SpringRunner.class)
public class ClientServiceHelperTest {

	@InjectMocks
	private ClientServiceHelper unitToTest = new ClientServiceHelper();

	@Mock
	private FlockDB flockDb;

	@Mock
	private OrderRequest orderRequest;

	@Mock
	private Order order;

	@Test
	public void OrderRequest_Positive_test() {
		when(orderRequest.getOrder()).thenReturn(order);
		when(order.getMilk()).thenReturn(10.00);
		when(order.getWool()).thenReturn(10.00);
		when(flockDb.getTotalMilk()).thenReturn(50.00);
		when(flockDb.getTotalWool()).thenReturn(47.00);

		boolean response = unitToTest.checkStockAvailability(flockDb, orderRequest);

		assertTrue(response);
	}

	@Test
	public void OrderRequest_Negative_test() {
		when(orderRequest.getOrder()).thenReturn(order);
		when(order.getMilk()).thenReturn(10.00);
		when(order.getWool()).thenReturn(10.00);
		when(flockDb.getTotalMilk()).thenReturn(8.00);
		when(flockDb.getTotalWool()).thenReturn(47.00);

		boolean response = unitToTest.checkStockAvailability(flockDb, orderRequest);

		assertFalse(response);
	}

}
