package com.ajxtech.cruzeiroec.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajxtech.cruzeiroec.model.Stadium;
import com.ajxtech.cruzeiroec.repository.StadiumRepository;

import jakarta.transaction.Transactional;

@Service
public class StadiumService {

	@Autowired
	private StadiumRepository stadiumRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(StadiumService.class);

	public List<Stadium> findAll() {
		logger.info("List of stadiums.");
		return stadiumRepository.findAll();
	}

	public Optional<Stadium> findById(Long id) {
		logger.info("Get stadium by ID: {}.", id);
		return stadiumRepository.findById(id);
	}

	@Transactional
	public Stadium save(Stadium stadium) {
		logger.info("Saving stadium.");
		return stadiumRepository.save(stadium);
	}

	@Transactional
	public Stadium update(Long id, Stadium updatedStadium) {
		logger.info("Updating stadium by ID: {}",id);
		return stadiumRepository.findById(id).map(stadium -> {
			stadium.setName(updatedStadium.getName());
			return stadiumRepository.save(stadium);
		}).orElseThrow(() -> new RuntimeException("Stadium not found."));
	}

	@Transactional
	public void delete(Long id) {
		logger.info("Removing stadium by ID: {}",id);
		stadiumRepository.deleteById(id);
	}
}
