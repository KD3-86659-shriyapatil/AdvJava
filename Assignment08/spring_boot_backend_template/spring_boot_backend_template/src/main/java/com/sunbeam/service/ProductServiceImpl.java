package com.sunbeam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ProductDTO;
import com.sunbeam.pojo.Products;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		Products prd=modelMapper.map(product, Products.class);
		productDao.save(prd);
		return "product Added Succesfully...BY ADMIN ..";
	}

	@Override
	public String softDelete(Long prdId) {
		// TODO Auto-generated method stub
		if(productDao.existsById(prdId)) {
			Products product=productDao.findById(prdId).orElseThrow();
			System.out.println(product.isStatus());
			if(product.isStatus()) {
				product.setStatus(false);
				return "Product deleted successfully....";
			}
			return "Product already deleted...";
		}
		return "product Not Available..";
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		List<Products> prd=productDao.findAll();
		return prd.stream().map(prdList-> modelMapper.map(prdList, ProductDTO.class)).collect(Collectors.toList());
	}
	
	
	
	
}
