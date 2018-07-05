package org.baeldung.service;

import java.util.List;

import org.baeldung.persistence.model.Sales;
import org.baeldung.persistence.model.SalesView;

public interface SalesService {

	void loadSales();

	List<SalesView> getSalesByDate();

	List<SalesView> getSalesByAccountAndDate();

	List<SalesView> getSalesByDateAndAccount();

	List<Sales> getSales();
	
}
