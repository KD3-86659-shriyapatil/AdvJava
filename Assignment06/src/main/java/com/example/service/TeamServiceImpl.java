package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.blogs.dto.ApiResponse;
import com.example.daos.TeamDao;
import com.example.pojos.Team;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class TeamServiceImpl  implements TeamService {
	@Autowired
	private TeamDao teamDao;
	
	
	@Override
	public List<Team> getAllTeamsDetails() {
		
		return teamDao.findAll();
	}
	@Override
	public String addNewTeam(Team team) {
		Team persistentTeam= teamDao.save(team);
		return "Team added successfully";
	}
	@Override
	public Team getTeamDetails(Long teamId) {
		
		return teamDao.findById(teamId).orElseThrow();
	}
	@Override
	public ApiResponse updateTeamDetails(Long teamId, Team team) {
		if(teamDao.existsById(teamId)) {
			return new ApiResponse("updated successfully...");
		}
		return new ApiResponse("Updation failed");
	}
	@Override
	public ApiResponse deleteTeamDetails(Long teamId) {
		
		if(teamDao.existsById(teamId)) {
			teamDao.deleteById(teamId);
			return new ApiResponse("deleted successfully...");
		}
		return new ApiResponse("Deletion failed");
	}
	}
	
	
	
	
	


