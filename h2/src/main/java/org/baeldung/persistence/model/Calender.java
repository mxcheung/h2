package org.baeldung.persistence.model;

import java.time.LocalDate;

public class Calender{

	LocalDate date;
	
	String exchange;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	
}
