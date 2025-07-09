package com.ajxtech.cruzeiroec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajxtech.cruzeiroec.model.Stadium;


@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {

}
