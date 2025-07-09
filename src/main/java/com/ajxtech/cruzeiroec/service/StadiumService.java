package com.ajxtech.cruzeiroec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajxtech.cruzeiroec.model.Stadium;
import com.ajxtech.cruzeiroec.repository.StadiumRepository;

import jakarta.transaction.Transactional;

@Service
public class StadiumService {

	@Autowired
	private StadiumRepository stadiumRepository;

	public List<Stadium> findAll() {
		return stadiumRepository.findAll();
	}

	public Optional<Stadium> findById(Long id) {
		return stadiumRepository.findById(id);
	}

	@Transactional
	public Stadium save(Stadium stadium) {
		return stadiumRepository.save(stadium);
	}

	@Transactional
	public Stadium update(Long id, Stadium updatedStadium) {
		return stadiumRepository.findById(id).map(stadium -> {
			stadium.setName(updatedStadium.getName());
			return stadiumRepository.save(stadium);
		}).orElseThrow(() -> new RuntimeException("Stadium not found."));
	}

	@Transactional
	public void delete(Long id) {
		stadiumRepository.deleteById(id);
	}
}
