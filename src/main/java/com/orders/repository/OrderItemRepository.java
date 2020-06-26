package com.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orders.model.Products;

@Repository
public interface OrderItemRepository extends JpaRepository<Products,Integer>{

}
