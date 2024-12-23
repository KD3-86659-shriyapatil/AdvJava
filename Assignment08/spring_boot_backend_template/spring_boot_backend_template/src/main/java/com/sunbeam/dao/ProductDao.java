package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojo.Products;

public interface ProductDao extends JpaRepository<Products, Long> {

}
