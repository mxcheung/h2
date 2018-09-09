package org.baeldung.service.holiday;

import java.time.LocalDate;
import java.util.List;

public interface HolidayService {

	List<LocalDate> getNBusinessDays(LocalDate currDate, long size, long daysToAdd);

	boolean isHoliday(LocalDate date);

	boolean isWorkingDay(LocalDate localDate);
	
}
