package com.example.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojos.Player;

public interface  PlayerDao extends JpaRepository<Player, Long>{

}
