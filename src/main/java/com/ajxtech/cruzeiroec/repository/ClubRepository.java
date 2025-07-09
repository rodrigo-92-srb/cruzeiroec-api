package com.ajxtech.cruzeiroec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajxtech.cruzeiroec.model.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long>{

}
