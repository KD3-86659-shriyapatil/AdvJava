package com.example.service;

import java.util.List;

import com.blogs.dto.ApiResponse;
import com.example.pojos.Team;

public interface TeamService  {
   String addNewTeam(Team team);
   List<Team> getAllTeamsDetails();
//   Team getAllDetails(Long teamId) ;
   Team getTeamDetails(Long teamId);
   ApiResponse updateTeamDetails (Long teamId,Team team);
   ApiResponse deleteTeamDetails(Long teamId);
   

	

   
}
