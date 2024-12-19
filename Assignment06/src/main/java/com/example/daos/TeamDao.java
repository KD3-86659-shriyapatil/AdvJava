package com.example.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojos.Team;

public interface TeamDao extends JpaRepository<Team, Long>{

}
