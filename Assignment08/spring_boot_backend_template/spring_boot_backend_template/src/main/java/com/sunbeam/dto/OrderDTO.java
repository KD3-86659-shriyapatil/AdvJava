package com.sunbeam.dto;

import com.sunbeam.pojo.Products;
import com.sunbeam.pojo.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDTO extends BaseEntityDTO {
	private Long prdId;
	private double quantity;
	
//	private Products productid;
//	
//	private User userid;
}
