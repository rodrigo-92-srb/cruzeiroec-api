package com.ajxtech.cruzeiroec.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajxtech.cruzeiroec.model.Club;
import com.ajxtech.cruzeiroec.repository.ClubRepository;

import jakarta.transaction.Transactional;


@Service
public class ClubService {

	@Autowired
	private ClubRepository clubRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ClubService.class);
	
	public List<Club> findAll(){
		logger.info("List of clubs.");
		return clubRepository.findAll();
	}
	
	@Transactional
    public Club save(Club club) {
		logger.info("Saving club.");
        return clubRepository.save(club);
    }
	
	 @Transactional
	 public Club update(Long id, Club updatedClub) {
		 logger.info("Updating club by ID: {}",id);
	   return clubRepository.findById(id).map(club -> {
		  club.setName(updatedClub.getName());
	      return clubRepository.save(club);
	   }).orElseThrow(() -> new RuntimeException("Club not found."));
	 }
	 
	 @Transactional
	 public void delete(Long id) {
		logger.info("Removing club by ID: {}",id);
	    clubRepository.deleteById(id);
	 }
}
