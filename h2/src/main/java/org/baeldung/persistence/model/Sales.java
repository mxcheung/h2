package org.baeldung.persistence.model;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "account")
    private String account;
    
    @Column(name = "transaction_date", length = 35)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate transactionDate;
    
    @Column(name = "currency", length = 3)
    private String currency;
    
    @Column(name = "amount")
    private BigDecimal amount;

	public Sales() {
		super();
	}

	public Sales(String account, LocalDate transactionDate, String currency, BigDecimal amount) {
		super();
		this.account = account;
		this.transactionDate = transactionDate;
		this.currency = currency;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
    
    
    
    
}
