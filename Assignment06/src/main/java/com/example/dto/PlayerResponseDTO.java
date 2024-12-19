package com.example.dto;

import java.time.LocalDate;

import com.example.pojos.BaseEntity;
import com.example.pojos.Team;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class PlayerResponseDTO extends BaseEntity{
	private String first_name;
	private String last_name;
	private LocalDate dob;
	private double battingAvg;
    private int wicketTaken;
    
}