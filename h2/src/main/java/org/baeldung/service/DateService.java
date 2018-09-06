package org.baeldung.service;

import java.time.LocalDate;
import java.util.List;

public interface DateService {

	List<LocalDate> getNBusinessDays(LocalDate currDate, long size);
	
}
