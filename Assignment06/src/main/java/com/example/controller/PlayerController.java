package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PlayerResponseDTO;
import com.example.service.PlayerService;



@RestController
@RequestMapping("/players")
@CrossOrigin(origins="http://localhost:3000")
public class PlayerController {
     @Autowired
     private PlayerService playerService;
     
     @GetMapping
     public ResponseEntity<?> getAllPlayers(){
		System.out.println("All Players Details-");
		List<PlayerResponseDTO> players=playerService.getAllPlayer();
		if(players.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
    	 return ResponseEntity.ok(players);
    	 
     }
}
