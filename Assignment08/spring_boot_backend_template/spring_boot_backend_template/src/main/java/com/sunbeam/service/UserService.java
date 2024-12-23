package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.UserDTO;
import com.sunbeam.pojo.User;

public interface UserService {

	String addUser(UserDTO user);

	List<UserDTO> getAllUsers();

	String deleteUser(Long userId);

	UserDTO getUserById(Long userId);

	String updateUser(Long userId, User user);

	UserDTO updateUserss(User user);

}
