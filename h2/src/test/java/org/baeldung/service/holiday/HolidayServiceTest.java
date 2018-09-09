package org.baeldung.service.holiday;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.baeldung.persistence.model.Calender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HolidayServiceTest {

	private static final String EXCHANGE = "exchange";

	@Mock
	private CalenderService calenderService;

	private HolidayService holidayService;

	private LocalDate startDate = LocalDate.of(2019, 2, 1);
	private Calender holiday1 = createHoliday(LocalDate.of(2019, 2, 5), EXCHANGE);
	private Calender holiday2 = createHoliday(LocalDate.of(2019, 2, 6), EXCHANGE);

	@Before
	public void setup() throws Exception {
		holidayService = new HolidayServiceImpl(calenderService);
		initMock(startDate, 10);
		Mockito.when(calenderService.getCalender(holiday1.getDate(), EXCHANGE)).thenReturn(Arrays.asList(holiday1));
		Mockito.when(calenderService.getCalender(holiday2.getDate(), EXCHANGE)).thenReturn(Arrays.asList(holiday2));
	}

	@Test
	public void getNBusinessDays() {
		List<LocalDate> expected = Arrays.asList(LocalDate.of(2019, 2, 4), LocalDate.of(2019, 2, 7));
		List<LocalDate> nextBusinessDays = holidayService.getNBusinessDays(LocalDate.of(2019, 2, 4), 2, 1);
		List<LocalDate> prevBusinessDays = holidayService.getNBusinessDays(LocalDate.of(2019, 2, 7), 2, -1);
		Collections.sort(prevBusinessDays);
		assertEquals(expected, prevBusinessDays);
		assertEquals(expected, nextBusinessDays);
	}


	@Test
	public void isHoliday() {
		assertFalse(holidayService.isHoliday(startDate));
		assertTrue(holidayService.isWorkingDay(startDate));
		assertTrue(holidayService.isHoliday(holiday1.getDate()));
	}
	private Calender createHoliday(LocalDate date, String exchange) {
		Calender calender = new Calender();
		calender.setDate(date);
		calender.setExchange(exchange);
		return calender;
	}

	private void initMock(LocalDate sd, long maxSize) {
		Stream.iterate(startDate, date -> date.plusDays(1)).limit(maxSize).forEach(date -> {
			Mockito.when(calenderService.getCalender(date, EXCHANGE)).thenReturn(Collections.emptyList());
		});
	}

}
