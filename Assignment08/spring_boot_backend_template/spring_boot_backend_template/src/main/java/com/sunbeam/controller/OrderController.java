package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.OrderDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.pojo.Orders;
import com.sunbeam.pojo.User;
import com.sunbeam.service.OrderService;
import com.sunbeam.service.ProductService;
import com.sunbeam.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping("/{userId}")
	public ResponseEntity<?> placeOrder(@PathVariable Long userId,@RequestBody OrderDTO order){
		UserDTO user=userService.getUserById(userId);
		String role=user.getRole().toString();
		if(role.equals("CUSTOMER")) {
			return ResponseEntity.ok(orderService.placeOrderByCustumer(userId,order));
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();	
	}
	@GetMapping("/{userId}/{ordId}")
	public ResponseEntity<?> getAllPlacedOrders(@PathVariable Long userId,@PathVariable Long ordId,@RequestBody Orders order){
		UserDTO user=userService.getUserById(userId);
		String role=user.getRole().toString();
		if(role.equals("ADMIN")) {
			return ResponseEntity.ok(orderService.getAllOrders());
		}
		return null;
		
	}
	
}
