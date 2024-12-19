package com.example.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ApiResponse {
  private String message;
  private LocalDate timeStamp;
public ApiResponse(String message, LocalDate timeStamp) {
	super();
	this.message = message;
	this.timeStamp = timeStamp;
}
  
  
  
}
