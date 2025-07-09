package com.ajxtech.cruzeiroec.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Club {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private int founded;

    @Column(columnDefinition = "TEXT")
    private String history; 

    @Column(columnDefinition = "TEXT")
    private String interestingFacts; 

    @Column(columnDefinition = "TEXT")
    private String campaigns; 

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFounded() {
		return founded;
	}

	public void setFounded(int founded) {
		this.founded = founded;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getInterestingFacts() {
		return interestingFacts;
	}

	public void setInterestingFacts(String interestingFacts) {
		this.interestingFacts = interestingFacts;
	}

	public String getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(String campaigns) {
		this.campaigns = campaigns;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	@Override
	public String toString() {
		return "Club [name=" + name + ", founded=" + founded + ", stadium=" + stadium + "]";
	}

}
