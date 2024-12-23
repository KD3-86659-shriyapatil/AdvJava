package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.OrderDTO;
import com.sunbeam.dto.ProductDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.pojo.User;
import com.sunbeam.service.OrderService;
import com.sunbeam.service.ProductService;
import com.sunbeam.service.UserService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService; 
	
	@PostMapping("/{userId}")
	public ResponseEntity<?> addNewProduct(@PathVariable Long userId,@RequestBody ProductDTO product){
		System.out.println("product me :"+userService.getUserById(userId).getRole());
		UserDTO user=userService.getUserById(userId);
		String role=user.getRole().toString();
		System.out.println(role); 
		if(role.equals("ADMIN")) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.addProduct(product));
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();	
	}
	
	@DeleteMapping("/{userId}/{prdId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long userId,@PathVariable Long prdId){
		UserDTO user=userService.getUserById(userId);
		String role=user.getRole().toString();
		if(role.equals("ADMIN")) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.softDelete(prdId));
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getAllProducts(@PathVariable Long userId){
		UserDTO user=userService.getUserById(userId);
		String role=user.getRole().toString();
		if(role.equals("CUSTOMER")) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.getAllProducts());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
//	@PostMapping("/{userId}/{prdId}")
//	public ResponseEntity<?> placeOrder(@PathVariable Long userId,@PathVariable Long prdId,@RequestBody OrderDTO order){
//		UserDTO user=userService.getUserById(userId);
//		String role=user.getRole().toString();
//		if(role.equals("CUSTOMER")) {
//			return ResponseEntity.ok(orderService.placeOrderByCustumer(userId,prdId, order));
//		}
//		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();	
//	}
	
//	@PostMapping("/{userId}")
//	public ResponseEntity<?> placeOrder(@PathVariable Long userId,@RequestBody OrderDTO order){
//		UserDTO user=userService.getUserById(userId);
//		String role=user.getRole().toString();
//		if(role.equals("CUSTOMER")) {
//			return ResponseEntity.ok(orderService.placeOrderByCustumer(userId,order));
//		}
//		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();	
//	}
}






