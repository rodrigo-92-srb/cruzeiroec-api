package com.ajxtech.cruzeiroec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stadium {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private String name;
	 
	 private int capacity;

	 @Column(columnDefinition = "TEXT")
	 private String history;

	 private String attendanceRecord;

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

	 public int getCapacity() {
		 return capacity;
	 }

	 public void setCapacity(int capacity) {
		 this.capacity = capacity;
	 }

	 public String getHistory() {
		 return history;
	 }

	 public void setHistory(String history) {
		 this.history = history;
	 }

	 public String getAttendanceRecord() {
		 return attendanceRecord;
	 }

	 public void setAttendanceRecord(String attendanceRecord) {
		 this.attendanceRecord = attendanceRecord;
	 }

	 @Override
	 public String toString() {
		return "Stadium [name=" + name + ", capacity=" + capacity + "]";
	 }
	 
	 
	
}
