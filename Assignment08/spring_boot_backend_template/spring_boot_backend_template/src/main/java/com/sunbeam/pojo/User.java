package com.sunbeam.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Users")

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User extends BaseEntity {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	@Column(name="role",length=30)
	private UserRole role;
	
//	@Lob
//	private byte[] image;
//	
//	@OneToMany
//	@JoinColumn(name="address_id")
//	private Address address;
	
}
