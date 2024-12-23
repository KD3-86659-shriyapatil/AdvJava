package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
	private String name;
    private double price;
    private String discription;
    private boolean status;
}
