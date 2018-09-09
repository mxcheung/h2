package org.baeldung.service.holiday;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.baeldung.persistence.model.Calender;

public class CalenderServiceImpl implements CalenderService {

	
	private List<LocalDate> holiday = new ArrayList<>();
	
	
	public CalenderServiceImpl() {
		holiday.add(LocalDate.of(2019, 2, 5));		
		holiday.add(LocalDate.of(2019, 2, 6));		
	}
	
	
	@Override
	public List<Calender> getCalender(LocalDate currDate, String exchange) {
		List<Calender> calenders = new ArrayList<>();
		return calenders;
	}

	
}
