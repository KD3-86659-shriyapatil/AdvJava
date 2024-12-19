package com.example.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.PlayerDao;
import com.example.dto.PlayerResponseDTO;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
@Service
@Transactional
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	private PlayerDao playerDao;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<PlayerResponseDTO> getAllPlayer() {
		return playerDao.findAll()
				.stream()
				.map(player -> modelMapper.map(player, PlayerResponseDTO.class))
				.collect(Collectors.toList());
		}
 
}
