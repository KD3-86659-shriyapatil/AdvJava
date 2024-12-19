package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.example.pojos.Team;
import com.example.service.TeamService;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	public TeamController() {
	System.out.println("in ctor-"+getClass());
	}
	
	
	@GetMapping
	public ResponseEntity<?> getAllTeam(){
		System.out.println("All Teams-");
		List<Team> teams= teamService.getAllTeamsDetails();
		if(teams.isEmpty())
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(teams);
		
	}
	@PostMapping
	public ResponseEntity<?> addNewTeam(@RequestBody Team team){
		System.out.println("Team added successfully.."+team);
		return ResponseEntity.status(HttpStatus.CREATED).body(teamService.addNewTeam(team));
		
		
	}
	
//	URL-/teams/{teamId}
//	METHOD-get
//	PAYLOAD-Uri variable=>teamid 
//	RESP-team => json
//	DESC-get the teams details
	
@GetMapping ("/{teamId}")
public ResponseEntity<?> getTeamDetails(@PathVariable Long teamId){
	System.out.println("Deatils of Team-");
	try {
		Team team=teamService.getTeamDetails(teamId);
		return ResponseEntity.ok(team);
	}catch(RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(e.getMessage()));
	}
	
}

//URL-teams/teamId
//METHOD-put
//PAYLOAD-reqeust param
//RESP-
//DESC-update team details

@PutMapping("/{teamId}")
public ResponseEntity<?> updateTeamDetails(@PathVariable Long teamId,@RequestBody Team team){
	System.out.println("get team details"+teamId+""+team);
	
	return ResponseEntity.ok(teamService.updateTeamDetails(teamId, team));
	
}

@DeleteMapping
public ResponseEntity<?> deleteTeamDetails(@PathVariable Long teamId){
	System.out.println("team deleted-"+teamId);
	try {
		return ResponseEntity.ok(teamService.deleteTeamDetails(teamId));
	}catch(RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(e.getMessage()));
	}

	
}

}
