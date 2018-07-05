package org.baeldung.service;

import static java.util.stream.Collectors.groupingBy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.baeldung.persistence.model.Sales;
import org.baeldung.persistence.model.SalesView;
import org.baeldung.persistence.repo.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesRepository salesRepository;

	@Override
	public List<Sales> getSales() {
		return  (List<Sales>) salesRepository.findAll();
	}

	@Override
	public List<SalesView> getSalesByDate() {
		List<Sales> sales = (List<Sales>) salesRepository.findAll();
		List<SalesView> salesViews = new ArrayList<>();
		Map<LocalDate, List<Sales>> salesByGroup = sales.stream().collect(groupingBy(Sales::getTransactionDate));
		salesByGroup.forEach((k, v) -> {
			SalesView salesView = new SalesView(k, v);
			salesViews.add(salesView);
		});
		return salesViews;
	}

	@Override
	public List<SalesView> getSalesByAccountAndDate() {
		List<Sales> sales = (List<Sales>) salesRepository.findAll();
		List<SalesView> salesViews = new ArrayList<>();
		Map<String, Map<LocalDate, List<Sales>>> salesByGroup = sales.stream()
				.collect(groupingBy(Sales::getAccount, groupingBy(Sales::getTransactionDate)));
		salesByGroup.forEach((account, v1) -> {
			v1.forEach((tranDate, groupedSales) -> {
				SalesView salesView = new SalesView(account, tranDate, groupedSales);
				salesViews.add(salesView);
			});
		});
		return salesViews;
	}

	@Override
	public List<SalesView> getSalesByDateAndAccount() {
		List<Sales> sales = (List<Sales>) salesRepository.findAll();
		List<SalesView> salesViews = new ArrayList<>();
		Map<LocalDate, Map<String, List<Sales>>> salesByGroup = sales.stream()
				.collect(groupingBy(Sales::getTransactionDate, groupingBy(Sales::getAccount)));
		salesByGroup.forEach((tranDate, v1) -> {
			v1.forEach((account, groupedSales) -> {
				SalesView salesView = new SalesView(account, tranDate, groupedSales);
				salesViews.add(salesView);
			});
		});
		return salesViews;
	}

	@Override
	public void loadSales() {
		// TODO Auto-generated method stub
		List<Sales> sales = new ArrayList<Sales>();
		String account1 = "account1";
		String account2 = "account2";
		LocalDate tranDate1 = LocalDate.of(2018, 1, 1);
		LocalDate tranDate2 = LocalDate.of(2018, 1, 2);
		sales.add(new Sales(account1, tranDate1, "AUD", BigDecimal.ONE));
		sales.add(new Sales(account1, tranDate1, "USD", BigDecimal.TEN));
		sales.add(new Sales(account2, tranDate1, "USD", BigDecimal.TEN));
		sales.add(new Sales(account2, tranDate2, "USD", BigDecimal.TEN));
		salesRepository.saveAll(sales);

	}

}