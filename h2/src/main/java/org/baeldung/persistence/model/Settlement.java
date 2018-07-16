package org.baeldung.persistence.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

public class Settlement {

	@Column(name = "cdp_settlement_id")
	private String cdpSettlementId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "settlement_system_id")
	private Long settlementSystemId;

	@Column(name = "settlement_status_id")
	private Integer settlementStatusId;

	@Column(name = "previous_valid_settlement_status_id")
	private Integer previousValidSettlementStatusId;

	@Transient
	@Enumerated(EnumType.ORDINAL)
	private SettlementStatus settlementStatus;

	@Transient
	@Enumerated(EnumType.ORDINAL)
	private SettlementStatus previousValidSettlementStatus;

	@Column(name = "linked_settlement_system_id")
	private Long linkedSettlementSystemId;

	@Column(name = "exchange_trade_reference")
	private String exchangeTradeReference;

	@Column(name = "settlement_type")
	@Enumerated(EnumType.STRING)
	private SettlementType settlementType;

	@Column(name = "earmark_flag")
	@Enumerated(EnumType.ORDINAL)
	private EarmarkFlag earmarkFlag;
//		@Column(name = "offMarket_reference")

	//java.sql.SQLException: Invalid column name 'off_market_reference'. private String offmarketReference;

	@Column(name = "transaction_type")
	private String transactionType;

	@Column(name = "place_of_settlement")
	private String placeOfSettlement;

	@Column(name = "safe_deliver_receive")
	@Enumerated(EnumType.STRING)
	private SafeDeliverReceive safeDeliverReceive;

	@Column(name = "fopdvp")
	@Enumerated(EnumType.STRING)
	private FOPDVP fopDvp;

	@Column(name = "isin")
	private String isin;

	@Column(name = "quantity")
	private BigDecimal quantity;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "currency")
	private String currency;

	@Column(name = "accrued_interest_amount")
	private BigDecimal accruedInterestAmount;

	@Column(name = "accrued_interest_amount_currency")
	private String accruedInterestAmountCurrency;

	@Column(name = "trade_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tradeDate;

	@Column(name = "settlement_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate settlementDate;

	@Column(name = "deal_price")
	private BigDecimal dealPrice;

	@Column(name = "deal_price_currency")
	private String dealPriceCurrency;

	@Column(name = "account_owner_id")
	private String accountOwnerId;

	@Column(name = "account_owner_id_type")
	private String accountOwnerIdType;

	@Column(name = "safekeeping_account")
	private String safekeepingAccount;

	@Column(name = "depository")
	private String depository;

	@Column(name = "counterparty_id")
	private String counterpartyId;

	@Column(name = "counterparty_id_type")
	private String counterpartyIdType;

	@Column(name = "corporate_action_reference")
	private String corporateActionReference;

	@Column(name = "previous_cdp_settlement_id")
	private String previousCdpSettlementSystemId;

	@Column(name = "matched_cdp_settlement_id")
	private String matchedCdpSettlementSystemId;

	@Column(name = "matched_amount")
	private BigDecimal matchedAmount;

	@Column(name = "rejected_reason")
	private String rejectedReason;

	@Column(name = "full_settlement")
	private String fullSettlement;

	@Column(name = "settled_quantity")
	private BigDecimal settledQuantity;

	@Column(name = "settled_amount")
	private BigDecimal settledAmount;

	@Transient
	private String micsProductKey;

	@Transient
	private String micsSymbol;

	@Column(name = "maker_user_id")
	private String createdBy;

	@Column(name = "checker_user_id")
	private String verifiedBy;

	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;

	@Column(name = "confirm_reason")
	private String confirmReason;

	@Transient
	private String allocationPartyId;

	public String getCdpSettlementId() {
		return cdpSettlementId;
	}

	public void setCdpSettlementId(String cdpSettlementId) {
		this.cdpSettlementId = cdpSettlementId;
	}

	public Long getSettlementSystemId() {
		return settlementSystemId;
	}

	public void setSettlementSystemId(Long settlementSystemId) {
		this.settlementSystemId = settlementSystemId;
	}

	public Integer getSettlementStatusId() {
		return settlementStatusId;
	}

	public void setSettlementStatusId(Integer settlementStatusId) {
		this.settlementStatusId = settlementStatusId;
	}

	public Integer getPreviousValidSettlementStatusId() {
		return previousValidSettlementStatusId;
	}

	public void setPreviousValidSettlementStatusId(Integer previousValidSettlementStatusId) {
		this.previousValidSettlementStatusId = previousValidSettlementStatusId;
	}

	public SettlementStatus getSettlementStatus() {
		return settlementStatus;
	}

	public void setSettlementStatus(SettlementStatus settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	public SettlementStatus getPreviousValidSettlementStatus() {
		return previousValidSettlementStatus;
	}

	public void setPreviousValidSettlementStatus(SettlementStatus previousValidSettlementStatus) {
		this.previousValidSettlementStatus = previousValidSettlementStatus;
	}

	public Long getLinkedSettlementSystemId() {
		return linkedSettlementSystemId;
	}

	public void setLinkedSettlementSystemId(Long linkedSettlementSystemId) {
		this.linkedSettlementSystemId = linkedSettlementSystemId;
	}

	public String getExchangeTradeReference() {
		return exchangeTradeReference;
	}

	public void setExchangeTradeReference(String exchangeTradeReference) {
		this.exchangeTradeReference = exchangeTradeReference;
	}

	public SettlementType getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(SettlementType settlementType) {
		this.settlementType = settlementType;
	}

	public EarmarkFlag getEarmarkFlag() {
		return earmarkFlag;
	}

	public void setEarmarkFlag(EarmarkFlag earmarkFlag) {
		this.earmarkFlag = earmarkFlag;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getPlaceOfSettlement() {
		return placeOfSettlement;
	}

	public void setPlaceOfSettlement(String placeOfSettlement) {
		this.placeOfSettlement = placeOfSettlement;
	}

	public SafeDeliverReceive getSafeDeliverReceive() {
		return safeDeliverReceive;
	}

	public void setSafeDeliverReceive(SafeDeliverReceive safeDeliverReceive) {
		this.safeDeliverReceive = safeDeliverReceive;
	}

	public FOPDVP getFopDvp() {
		return fopDvp;
	}

	public void setFopDvp(FOPDVP fopDvp) {
		this.fopDvp = fopDvp;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAccruedInterestAmount() {
		return accruedInterestAmount;
	}

	public void setAccruedInterestAmount(BigDecimal accruedInterestAmount) {
		this.accruedInterestAmount = accruedInterestAmount;
	}

	public String getAccruedInterestAmountCurrency() {
		return accruedInterestAmountCurrency;
	}

	public void setAccruedInterestAmountCurrency(String accruedInterestAmountCurrency) {
		this.accruedInterestAmountCurrency = accruedInterestAmountCurrency;
	}

	public LocalDate getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	public BigDecimal getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(BigDecimal dealPrice) {
		this.dealPrice = dealPrice;
	}

	public String getDealPriceCurrency() {
		return dealPriceCurrency;
	}

	public void setDealPriceCurrency(String dealPriceCurrency) {
		this.dealPriceCurrency = dealPriceCurrency;
	}

	public String getAccountOwnerId() {
		return accountOwnerId;
	}

	public void setAccountOwnerId(String accountOwnerId) {
		this.accountOwnerId = accountOwnerId;
	}

	public String getAccountOwnerIdType() {
		return accountOwnerIdType;
	}

	public void setAccountOwnerIdType(String accountOwnerIdType) {
		this.accountOwnerIdType = accountOwnerIdType;
	}

	public String getSafekeepingAccount() {
		return safekeepingAccount;
	}

	public void setSafekeepingAccount(String safekeepingAccount) {
		this.safekeepingAccount = safekeepingAccount;
	}

	public String getDepository() {
		return depository;
	}

	public void setDepository(String depository) {
		this.depository = depository;
	}

	public String getCounterpartyId() {
		return counterpartyId;
	}

	public void setCounterpartyId(String counterpartyId) {
		this.counterpartyId = counterpartyId;
	}

	public String getCounterpartyIdType() {
		return counterpartyIdType;
	}

	public void setCounterpartyIdType(String counterpartyIdType) {
		this.counterpartyIdType = counterpartyIdType;
	}

	public String getCorporateActionReference() {
		return corporateActionReference;
	}

	public void setCorporateActionReference(String corporateActionReference) {
		this.corporateActionReference = corporateActionReference;
	}

	public String getPreviousCdpSettlementSystemId() {
		return previousCdpSettlementSystemId;
	}

	public void setPreviousCdpSettlementSystemId(String previousCdpSettlementSystemId) {
		this.previousCdpSettlementSystemId = previousCdpSettlementSystemId;
	}

	public String getMatchedCdpSettlementSystemId() {
		return matchedCdpSettlementSystemId;
	}

	public void setMatchedCdpSettlementSystemId(String matchedCdpSettlementSystemId) {
		this.matchedCdpSettlementSystemId = matchedCdpSettlementSystemId;
	}

	public BigDecimal getMatchedAmount() {
		return matchedAmount;
	}

	public void setMatchedAmount(BigDecimal matchedAmount) {
		this.matchedAmount = matchedAmount;
	}

	public String getRejectedReason() {
		return rejectedReason;
	}

	public void setRejectedReason(String rejectedReason) {
		this.rejectedReason = rejectedReason;
	}

	public String getFullSettlement() {
		return fullSettlement;
	}

	public void setFullSettlement(String fullSettlement) {
		this.fullSettlement = fullSettlement;
	}

	public BigDecimal getSettledQuantity() {
		return settledQuantity;
	}

	public void setSettledQuantity(BigDecimal settledQuantity) {
		this.settledQuantity = settledQuantity;
	}

	public BigDecimal getSettledAmount() {
		return settledAmount;
	}

	public void setSettledAmount(BigDecimal settledAmount) {
		this.settledAmount = settledAmount;
	}

	public String getMicsProductKey() {
		return micsProductKey;
	}

	public void setMicsProductKey(String micsProductKey) {
		this.micsProductKey = micsProductKey;
	}

	public String getMicsSymbol() {
		return micsSymbol;
	}

	public void setMicsSymbol(String micsSymbol) {
		this.micsSymbol = micsSymbol;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getConfirmReason() {
		return confirmReason;
	}

	public void setConfirmReason(String confirmReason) {
		this.confirmReason = confirmReason;
	}

	public String getAllocationPartyId() {
		return allocationPartyId;
	}

	public void setAllocationPartyId(String allocationPartyId) {
		this.allocationPartyId = allocationPartyId;
	}

	
	
}