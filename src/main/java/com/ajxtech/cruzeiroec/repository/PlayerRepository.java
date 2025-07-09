package com.ajxtech.cruzeiroec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajxtech.cruzeiroec.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
