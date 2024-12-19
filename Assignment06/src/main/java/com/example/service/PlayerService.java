package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.daos.PlayerDao;
import com.example.dto.PlayerResponseDTO;

public interface PlayerService {

	 List<PlayerResponseDTO> getAllPlayer() ;
	

}
