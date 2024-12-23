package com.sunbeam.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.pojo.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public String addUser(UserDTO user) {
		// TODO Auto-generated method stub
		User users=modelMapper.map(user, User.class);
		try {
			System.out.println(users);
			userDao.save(users);
		return "user added successfully..."+users.getId();
		}catch (RuntimeException e) {
			return "User no Registered ....?";
		}
	}

	@Override
	public List<UserDTO> getAllUsers() {
		
		return userDao.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}

	@Override
	public String deleteUser(Long userId) {
		// TODO Auto-generated method stub
		if(userDao.existsById(userId)) {
			userDao.deleteById(userId);
			return "user deleted successfully...";
		}
		return "Wrong user id ..User not deleted !!!";
	}

	@Override
	public UserDTO getUserById(Long userId) {
		// TODO Auto-generated method stub
		System.out.println(userId);
//		Optional<User> usr=userDao.findById(userId);
//		System.out.println(usr);
//		return modelMapper.map(usr.orElseThrow(), UserDTO.class);//here we take the optional class so we require to convert the Optional to User so use usr.get() or usr.orElseThrow that convert this usr Optional class obj to User and if it is null throw the exception;
		
//		Optional<User> usr=userDao.findById(userId);
//		System.out.println(usr);
//		return modelMapper.map(usr.get(), UserDTO.class);//usr.get() give the user but when the user not available it will return the NullpoiterExp. so not recomended.
	
		User usr=userDao.findById(userId).orElseThrow();
		System.out.println(usr);
		return modelMapper.map(usr, UserDTO.class);
	}

	@Override
	public String updateUser(Long userId, User user) {
		if(userDao.existsById(userId)) {
			userDao.save(user);
			return "User updated successfully...";
		}
		return "user not updated !!!";
	}

	@Override
	public UserDTO updateUserss(User user) {
		if(userDao.existsById(user.getId())) {	
			User usr=userDao.save(user);
			return modelMapper.map(usr, null);
		}
		return null;
	}
	
}
