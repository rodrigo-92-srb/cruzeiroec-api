package com.ajxtech.cruzeiroec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajxtech.cruzeiroec.model.Club;
import com.ajxtech.cruzeiroec.repository.ClubRepository;

import jakarta.transaction.Transactional;


@Service
public class ClubService {

	@Autowired
	private ClubRepository clubRepository;
	
	
	public List<Club> findAll(){
		return clubRepository.findAll();
	}
	
	@Transactional
    public Club save(Club club) {
        return clubRepository.save(club);
    }
	
	 @Transactional
	 public Club update(Long id, Club updatedClub) {
	   return clubRepository.findById(id).map(club -> {
		  club.setName(updatedClub.getName());
	      return clubRepository.save(club);
	   }).orElseThrow(() -> new RuntimeException("Club not found."));
	 }
	 
	 @Transactional
	 public void delete(Long id) {
	    clubRepository.deleteById(id);
	 }
}
