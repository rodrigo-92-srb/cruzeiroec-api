package com.ajxtech.cruzeiroec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajxtech.cruzeiroec.model.Player;
import com.ajxtech.cruzeiroec.repository.PlayerRepository;

import jakarta.transaction.Transactional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }
    
    
    public Optional<Player> findById(Integer id) {
        return playerRepository.findById(id);
    }

    @Transactional
    public Player save(Player player) {
        return playerRepository.save(player);
    }
    
    @Transactional
    public Player update(Integer id, Player updatedPlayer) {
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
        playerRepository.deleteById(id);
    }
    
}