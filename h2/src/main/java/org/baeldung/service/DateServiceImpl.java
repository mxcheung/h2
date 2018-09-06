package org.baeldung.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class DateServiceImpl implements DateService {

	
	private List<LocalDate> holiday = new ArrayList<>();
	
	
	public DateServiceImpl() {
		holiday.add(LocalDate.of(2019, 2, 5));		
		holiday.add(LocalDate.of(2019, 2, 6));		
	}

	@Override
	public List<LocalDate> getNBusinessDays(LocalDate currDate, long size) {

		LocalDate start = currDate;
		LocalDate end = start.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
		List<LocalDate> dates = Stream
				.iterate(start, date -> date.plusDays(1))
				.filter(d -> (isWorkingDay(d) && !isHoliday(d) ))
				.limit(size)
				.collect(Collectors.toList());
		return dates;
	}

	private boolean isWorkingDay(LocalDate localDate) {
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		if ((dayOfWeek == DayOfWeek.SATURDAY) || (dayOfWeek == DayOfWeek.SUNDAY)) {
			return false;
		}
		return true;
	}

	private boolean isHoliday(LocalDate localDate) {
		return holiday.contains(localDate);
	}

}
