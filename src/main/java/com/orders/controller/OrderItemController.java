package com.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orders.model.ProductsDto;
import com.orders.serviceImpl.OrderItemServiceImpl;

@RestController
public class OrderItemController 
{
	@Autowired
	OrderItemServiceImpl service;
	
	@GetMapping("/retreiveOrderItems/{productCode}")
	public ProductsDto retreiveOrderItems(@PathVariable("productCode") Integer productCode)
	{
		return service.findByProducts(productCode);
	}
	
	@PostMapping("/createOrderItems")
	public String createOrderItem(@RequestBody ProductsDto dto)
	{
		boolean flag = service.createProducts(dto);
		
		if(flag=true)
			return "Product Created Successfully";
		else
			return "Product already exist";
	}
	

}
