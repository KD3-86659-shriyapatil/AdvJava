package com.sunbeam.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.dto.OrderDTO;
import com.sunbeam.pojo.Orders;

public interface OrderService {

//	String placeOrderByCustumer(Long userId,Long prdId,OrderDTO order);
	String placeOrderByCustumer(Long userId,OrderDTO order);

	List<OrderDTO> getAllOrders();
	
	
}
