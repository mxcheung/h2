package org.baeldung.service.holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.baeldung.persistence.model.Calender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HolidayServiceImpl implements HolidayService {

	private final CalenderService calenderService;
	
	@Autowired
	public HolidayServiceImpl(CalenderService calenderService) {
		super();
		this.calenderService = calenderService;
	}

	@Override
	public List<LocalDate> getNBusinessDays(LocalDate currDate, long size, long daysToAdd) {

		LocalDate start = currDate;
		LocalDate end = start.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
		List<LocalDate> dates = Stream
				.iterate(start, date -> date.plusDays(daysToAdd))
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

	private boolean isHoliday(LocalDate date) {
		List<Calender> calenderDates = calenderService.getCalender(date, "exchange");
		return (!calenderDates.isEmpty());
	}

}
