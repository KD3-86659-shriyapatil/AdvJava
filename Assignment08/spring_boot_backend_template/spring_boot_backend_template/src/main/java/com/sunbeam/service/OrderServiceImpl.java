package com.sunbeam.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.OrderDao;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.OrderDTO;
import com.sunbeam.dto.ProductDTO;
import com.sunbeam.pojo.Orders;
import com.sunbeam.pojo.Products;
import com.sunbeam.pojo.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String placeOrderByCustumer(Long userId, OrderDTO order) {
		
		User user = userDao.findById(userId).orElseThrow();
		Products prd=productDao.findById(order.getPrdId()).orElseThrow();
		
		Orders ord=modelMapper.map(order, Orders.class);
		System.out.println(ord);
		if(prd.getStock()-ord.getQuantity()>=0) {
			ord.setTotalPrice(prd.getPrice());
			ord.setProductid(prd);
			ord.setUserid(user);
			orderDao.save(ord);
			prd.setStock(prd.getStock()-ord.getQuantity());
			return "order placed successfully...";
		}
		return "Order Not placed..!!! product Not in stock...";
		}

	@Override
	public List<OrderDTO> getAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.findAll().stream().map(ordList->modelMapper.map(ordList, OrderDTO.class)).collect(Collectors.toList());
	}

//	@Override
//	public String placeOrderByCustumer(Long userId,Long prdId,OrderDTO order) {
//		
//		Products prd=productDao.findById(prdId).orElseThrow();
//		Orders ord=modelMapper.map(order, Orders.class);
//		System.out.println(ord);
//		if(prd.getStock()-ord.getQuantity()>=0) {
//			ord.setTotalPrice(prd.getPrice());
//			orderDao.save(ord);
//			prd.setStock(prd.getStock()-ord.getQuantity());
//			return "order placed successfully...";
//		}
//		return "Order Not placed..!!! product Not in stock...";
//	}
	
}
