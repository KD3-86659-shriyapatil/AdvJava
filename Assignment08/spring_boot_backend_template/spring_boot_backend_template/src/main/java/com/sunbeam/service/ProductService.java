package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ProductDTO;

public interface ProductService {

	String addProduct(ProductDTO product);

	String softDelete(Long prdId);

	List<ProductDTO> getAllProducts();

}
