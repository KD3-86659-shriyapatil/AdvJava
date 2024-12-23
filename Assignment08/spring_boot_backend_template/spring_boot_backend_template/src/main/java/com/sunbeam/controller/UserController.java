package com.sunbeam.controller;

import java.util.List;

import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.UserDTO;
import com.sunbeam.pojo.User;
import com.sunbeam.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody UserDTO user){
		try {
			System.out.println("postMapper" + user);
		return ResponseEntity.ok(userService.addUser(user));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}	
	}
	@GetMapping("/")
	public ResponseEntity<?> getAllUsers(){
//		try {
			List<UserDTO> user=userService.getAllUsers();
			System.out.println(user);
			return ResponseEntity.ok(user);
			
//		}catch (RuntimeException  e) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteById(@PathVariable Long userId){
		try {
			return ResponseEntity.ok(userService.deleteUser(userId));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}	
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long userId){
		try {
			return ResponseEntity.ok(userService.getUserById(userId));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	@PutMapping("/{userId}")
	public ResponseEntity<?> udateUser(@PathVariable Long userId,@RequestBody User user){
		try {
		return ResponseEntity.ok(userService.updateUser(userId,user));
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
	}
	
	@PutMapping
	public ResponseEntity<?> udateUsers(@RequestBody User user){
		try {
		return ResponseEntity.ok(userService.updateUserss(user));
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
	}
	
}
