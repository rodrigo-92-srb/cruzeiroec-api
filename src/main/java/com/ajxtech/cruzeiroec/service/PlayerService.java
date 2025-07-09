package com.ajxtech.cruzeiroec.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajxtech.cruzeiroec.model.Player;
import com.ajxtech.cruzeiroec.repository.PlayerRepository;

import jakarta.transaction.Transactional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(PlayerService.class);

    public List<Player> findAll() {
    	logger.info("List of players");
        return playerRepository.findAll();
    }
    
    
    public Optional<Player> findById(Integer id) {
    	logger.info("Get player by ID: {}",id);
        return playerRepository.findById(id);
    }

    @Transactional
    public Player save(Player player) {
    	logger.info("Saving player.");
        return playerRepository.save(player);
    }
    
    @Transactional
    public Player update(Integer id, Player updatedPlayer) {
    	logger.info("Updating player by ID: {}",id);
        return playerRepository.findById(id).map(player -> {
            player.setName(updatedPlayer.getName());
            player.setAge(updatedPlayer.getAge());
            player.setHeight(updatedPlayer.getHeight());
            player.setRole(updatedPlayer.getRole());
            return playerRepository.save(player);
        }).orElseThrow(() -> new RuntimeException("Player not found."));
    }
    
    @Transactional
    public void delete(Integer id) {
    	logger.info("Removing player by ID: {}",id);
        playerRepository.deleteById(id);
    }
    
}