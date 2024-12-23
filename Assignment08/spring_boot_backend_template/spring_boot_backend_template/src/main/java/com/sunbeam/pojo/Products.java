package com.sunbeam.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="products")
@Getter
@Setter
@ToString

public class Products extends BaseEntity {
    
	private String name;
    private double price;
    private String discription;
    private double stock;
    private boolean status;

}
