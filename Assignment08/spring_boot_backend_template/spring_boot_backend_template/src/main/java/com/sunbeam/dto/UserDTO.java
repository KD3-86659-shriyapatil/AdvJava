package com.sunbeam.dto;

import java.time.LocalDate;

import com.sunbeam.pojo.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserDTO {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate dob;
	private UserRole role;
}
