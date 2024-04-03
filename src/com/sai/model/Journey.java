package com.sai.model;

import java.time.LocalDate;

public class Journey {
	private LocalDate journeydate;
	private int no_of_passengers;
	
	public LocalDate getJourneydate() {
		return journeydate;
	}
	public void setJourneydate(LocalDate journeydate) {
		this.journeydate=journeydate;
	}
	public int getNo_of_passengers() {
		return no_of_passengers;
		
	}
	public void setNo_of_passengers(int no_of_passengers) {
		this.no_of_passengers=no_of_passengers;
	}
	
	public Journey(LocalDate journeydate, int no_of_passengers){
		
		this.journeydate=journeydate;
		this.no_of_passengers=no_of_passengers;
		
	}
	@Override
	public String toString() {
		return "Journey [journeydate=" + journeydate + ", no_of_passengers=" + no_of_passengers + "]";
	}
	

}
