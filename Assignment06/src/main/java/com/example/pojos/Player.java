package com.example.pojos;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="players")

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Player extends BaseEntity{
	@Column(length=50,name="first_Name")
	private String first_name;
	@Column(length=20,name="last_name")  //you can write 20 in name which should be write last name in name.
	private String last_name;
	
	private LocalDate dob;
	@Column(name = "battingAvg")
	private int battingAvg;
    private int wicketTaken;
	//BlogPost *--->1 Category
	
    @ManyToOne()
    @JoinColumn(name ="team_id")
    private Team team;



}

