package com.orders.service;

import com.orders.model.ProductsDto;

public interface OrderItemService 
{
	ProductsDto findByProducts(Integer productCode);
	
	boolean createProducts(ProductsDto dto);
	
}
