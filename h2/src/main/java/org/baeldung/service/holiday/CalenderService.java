package org.baeldung.service.holiday;

import java.time.LocalDate;
import java.util.List;

import org.baeldung.persistence.model.Calender;

public interface CalenderService {

	List<Calender> getCalender(LocalDate currDate, String exchange);
	
}
