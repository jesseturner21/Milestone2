package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class TestBlogsBusinessService implements BlogsBusinessServiceInterface{

	@Override
	public void test() {
		System.out.println("Hello");
		
	}

	@Override
	public List<BlogModel> getOrders() {
		// Create some Orders
				List<BlogModel> orders = new ArrayList<BlogModel>();
				
				return orders;
	}

}
