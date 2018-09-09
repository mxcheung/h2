package org.baeldung.service.holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HolidayServiceImpl implements HolidayService {

	private final CalenderService calenderService;
	private final List<DayOfWeek> weekend = Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

	@Autowired
	public HolidayServiceImpl(CalenderService calenderService) {
		super();
		this.calenderService = calenderService;
	}

	@Override
	public List<LocalDate> getNBusinessDays(LocalDate currDate, long size, long daysToAdd) {
		LocalDate start = currDate;
		List<LocalDate> dates = Stream
				.iterate(start, date -> date.plusDays(daysToAdd))
				.filter(d -> (isWorkingDay(d) && !isHoliday(d)))
				.limit(size)
				.collect(Collectors.toList());
		return dates;
	}

	@Override
	public boolean isHoliday(LocalDate date) {
		return (!calenderService.getCalender(date, "exchange").isEmpty());
	}

	@Override
	public boolean isWorkingDay(LocalDate localDate) {
		return !weekend.contains(localDate.getDayOfWeek());
	}


}
