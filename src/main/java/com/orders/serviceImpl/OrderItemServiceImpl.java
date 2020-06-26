package com.orders.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.model.Products;
import com.orders.model.ProductsDto;
import com.orders.repository.OrderItemRepository;
import com.orders.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService
{
	
	@Autowired
	OrderItemRepository repository;

	@Override
	public ProductsDto findByProducts(Integer productCode) {
		
		Optional<Products> opt = repository.findById(productCode);
		
		Products prd = opt.get();
		
		ProductsDto productsDto=new ProductsDto();
		
		BeanUtils.copyProperties(prd, productsDto);
		
		return productsDto;
	}

	@Override
	public boolean createProducts(ProductsDto dto) {
		
		boolean flag =  repository.existsById(dto.getProductCode());
		
		if(flag=true)
		{	
			Products prd = new Products();
			
			BeanUtils.copyProperties(dto, prd);
			
			repository.saveAndFlush(prd);
			
			return true;
			
		}
		else
			return false;
		
	}
	
	
}
