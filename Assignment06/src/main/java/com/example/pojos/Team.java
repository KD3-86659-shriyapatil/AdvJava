package com.example.pojos;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//JPA annotation
@Entity
@Table(name="teams")
//lombok annitation 
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Team extends BaseEntity{
	@Column(length = 100, unique =true )
	private String name;
	@Column(length = 10)
	private String abbreviation;
	@Column(length = 20, unique = true, nullable = false)
	private String owner;
	@Column(name="max_player_age")
	private int age;
	@Column(length = 20, name="batting_avg")
	private double battingAvg;
	@Column(length = 20, name="wickets_taken")
	private int wicketTaken;
	
//	@OneToMany(mappedBy = "team")
//	List<Player> players = new ArrayList<>();
	
 

	

	
	
}

