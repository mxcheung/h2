package org.baeldung.persistence.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesView {

    private String account;
    
    private LocalDate transactionDate;
    
    private Map<String, BigDecimal> amountByType;

	public SalesView(LocalDate transactionDate, List<Sales> sales) {
		super();
		this.transactionDate = transactionDate;
		this.amountByType = sales.stream().collect(
	                Collectors.toMap(Sales::getCurrency, Sales::getAmount));
		 
	}

	public SalesView(String account, LocalDate transactionDate, List<Sales> sales) {
		super();
		this.account = account;
		this.transactionDate = transactionDate;
		this.amountByType = sales.stream().collect(
                Collectors.toMap(Sales::getCurrency, Sales::getAmount));
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Map<String, BigDecimal> getAmountByType() {
		return amountByType;
	}

	public void setAmountByType(Map<String, BigDecimal> amountByType) {
		this.amountByType = amountByType;
	}
    
}
