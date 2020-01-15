package com.farmershop.v1.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.farmershop.service.FarmerService;
import com.farmershop.v1.controller.response.GetAvailableFlocksResponse;

@RunWith(SpringRunner.class)
@WebMvcTest(FarmerController.class)
public class FarmerControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private FarmerService farmerService;

	@Test
	public void FarmerController_test() throws Exception {
		GetAvailableFlocksResponse response = new GetAvailableFlocksResponse();
		given(farmerService.getAvailableFlocks()).willReturn(response);
		mvc.perform(get("/farmshop/admin/flocks").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
