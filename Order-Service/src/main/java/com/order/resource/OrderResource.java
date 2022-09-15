package com.order.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.bean.Order;
import com.order.service.OrderService;

@RestController
public class OrderResource {
	@Autowired
	private OrderService orderService;
	
	@PostMapping(path = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
	public Order saveOder(@RequestBody Order order) {
		return orderService.saveOrder(order);
		
	}

	
	@GetMapping(path = "/orders/{id}")
	public Order findOrderById (@PathVariable("id") Long id) {
		return orderService.findOrderById(id);
	}
}
