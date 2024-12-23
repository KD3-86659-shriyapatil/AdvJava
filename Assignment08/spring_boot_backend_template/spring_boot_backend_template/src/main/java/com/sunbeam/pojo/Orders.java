package com.sunbeam.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="orders")
@Getter
@Setter
@ToString

public class Orders extends BaseEntity {
	
//	private String title;
//	private String description;
	private double totalPrice;
	private double quantity;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Products productid;
	
	@ManyToOne  
	@JoinColumn(name="user_id")
	private User userid;
	

}
