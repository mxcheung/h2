package org.baeldung.persistence.model;

import java.time.LocalDate;
import java.util.List;

import org.baeldung.service.DateService;
import org.baeldung.service.DateServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class DateServiceTest {

	private DateService dateService = new DateServiceImpl();
	
	@Before
	public void setup() throws Exception {
	}
	
	@Test
	public void getNextDate()  {
		   List<LocalDate> nextDates = dateService.getNBusinessDays(LocalDate.of(2019, 2, 4), 10);
		   nextDates = nextDates;
	}
	
	
	
}

