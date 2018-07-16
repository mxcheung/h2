# h2
h2



<?xml version="1.0" encoding="UTF-8" ?>
	<cdpSettlementId />
	<settlementSystemId>84422</settlementSystemId>
	<settlementStatusId>2</settlementStatusId>
	<previousValidSettlementStatusId />
	<settlementStatus>SETTLEMENT_REQUEST_SENT</settlementStatus>
	<previousValidSettlementStatus />
	<linkedSettlementSystemId />
	<exchangeTradeReference>3hAO-a1593123</exchangeTradeReference>
	<settlementType>NORMAL</settlementType>
	<earmarkFlag />
	<offmarketReference />
	<transactionType>Trade</transactionType>
	<placeOfSettlement>CDPLSGSG</placeOfSettlement>
	<safeDeliverReceive>DELIVER</safeDeliverReceive>
	<fopDvp>FOP</fopDvp>
	<isin>SG1S03926213</isin>
	<quantity>10000</quantity>
	<amount>0</amount>
	<currency>SGD</currency>
	<accruedInterestAmount />
	<accruedInterestAmountCurrency />
	<tradeDate>2018-05-18</tradeDate>
	<settlementDate>2018-05-23</settlementDate>
	<dealPrice>1.22</dealPrice>
	<dealPriceCurrency>SGD</dealPriceCurrency>
	<accountOwnerId>FCSLSGSG</accountOwnerId>
	<accountOwnerIdType>BIC</accountOwnerIdType>
	<safekeepingAccount>215121009063</safekeepingAccount>
	<depository>CDPLSGSG</depository>
	<counterpartyId>213</counterpartyId>
	<counterpartyIdType>CDP</counterpartyIdType>
	<corporateActionReference />
	<previousCdpSettlementSystemId />
	<matchedCdpSettlementSystemId />
	<matchedAmount />
	<rejectedReason />
	<fullSettlement />
	<settledQuantity />
	<settledAmount />
	<micsProductKey />
	<micsSymbol />
	<createdBy>AUTO</createdBy>
	<verifiedBy />
	<lastUpdated>2018-05-21T15:00:00.263</lastUpdated>
	<confirmReason />
	<allocationPartyId />



{
  "cdpSettlementId": null,
  "settlementSystemId": 84422,
  "settlementStatusId": 2,
  "previousValidSettlementStatusId": null,
  "settlementStatus": "SETTLEMENT_REQUEST_SENT",
  "previousValidSettlementStatus": null,
  "linkedSettlementSystemId": null,
  "exchangeTradeReference": "3hAO-a1593123",
  "settlementType": "NORMAL",
  "earmarkFlag": null,
  "offmarketReference": null,
  "transactionType": "Trade",
  "placeOfSettlement": "CDPLSGSG",
  "safeDeliverReceive": "DELIVER",
  "fopDvp": "FOP",
  "isin": "SG1S03926213",
  "quantity": 10000,
  "amount": 0,
  "currency": "SGD",
  "accruedInterestAmount": null,
  "accruedInterestAmountCurrency": null,
  "tradeDate": "2018-05-18",
  "settlementDate": "2018-05-23",
  "dealPrice": 1.22,
  "dealPriceCurrency": "SGD",
  "accountOwnerId": "FCSLSGSG",
  "accountOwnerIdType": "BIC",
  "safekeepingAccount": "215121009063",
  "depository": "CDPLSGSG",
  "counterpartyId": "213",
  "counterpartyIdType": "CDP",
  "corporateActionReference": null,
  "previousCdpSettlementSystemId": null,
  "matchedCdpSettlementSystemId": null,
  "matchedAmount": null,
  "rejectedReason": null,
  "fullSettlement": null,
  "settledQuantity": null,
  "settledAmount": null,
  "micsProductKey": null,
  "micsSymbol": null,
  "createdBy": "AUTO",
  "verifiedBy": null,
  "lastUpdated": "2018-05-21T15:00:00.263",
  "confirmReason": null,
  "allocationPartyId": null
}



package com.abnamro.clearing.sgx_post_trade.common.domain.settlement;

import static com.abnamro.clearing.sgx_post_trade.SGXPostTradeReplacementConstants.ABN_AMRO_ACCOUNT_OWNER_ID;
import static com.abnamro.clearing.sgx_post_trade.SGXPostTradeReplacementConstants.ABN_AMRO_ACCOUNT_OWNER_ID_TYPE;
import static com.abnamro.clearing.sgx_post_trade.SGXPostTradeReplacementConstants.BIC_CODE_OF_CDP;
import static com.abnamro.clearing.sgx_post_trade.SGXPostTradeReplacementConstants.COUNTERPARTY_ID_NORMAL;
import static com.abnamro.clearing.sgx_post_trade.SGXPostTradeReplacementConstants.COUNTERPARTY_ID_TYPE;
import static com.abnamro.clearing.sgx_post_trade.SGXPostTradeReplacementConstants.POOL_ACCOUNT_ID;
import static com.abnamro.clearing.sgx_post_trade.SGXPostTradeReplacementConstants.TRANSACTION_TYPE;
import static com.abnamro.clearing.sgx_post_trade.common.domain.enumeration.SafeDeliverReceive.DELIVER;
import static com.abnamro.clearing.sgx_post_trade.common.domain.enumeration.SafeDeliverReceive.RECEIVE;
import static com.abnamro.clearing.sgx_post_trade.common.domain.enumeration.SettlementStatus.SETTLEMENT_AUTH_PENDING;
import static com.abnamro.clearing.sgx_post_trade.common.domain.enumeration.SettlementStatus.SETTLEMENT_NEW_SGX;
import static com.abnamro.clearing.sgx_post_trade.common.domain.enumeration.SettlementStatus.SETTLEMENT_REQUEST_NOT_SENT;
import static com.abnamro.clearing.sgx_post_trade.common.domain.enumeration.SettlementType.NORMAL;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import com.abnamro.clearing.sgx_post_trade.SGXPostTradeReplacementConstants;
import com.abnamro.clearing.sgx_post_trade.common.domain.AlternateProductId;
import com.abnamro.clearing.sgx_post_trade.common.domain.allocation.Allocation;
import com.abnamro.clearing.sgx_post_trade.common.domain.dion.DionSettlementNew;
import com.abnamro.clearing.sgx_post_trade.common.domain.enumeration.EarmarkFlag;
import com.abnamro.clearing.sgx_post_trade.common.domain.enumeration.FOPDVP;
import com.abnamro.clearing.sgx_post_trade.common.domain.enumeration.SafeDeliverReceive;
import com.abnamro.clearing.sgx_post_trade.common.domain.enumeration.SettlementStatus;
import com.abnamro.clearing.sgx_post_trade.common.domain.enumeration.SettlementType;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/**
 * @author agrawalv
 */
// @Table(schema = SGXPostTradeReplacementConstants.AAC_SCHEMA, name = "settlement", uniqueConstraints = {

@Table(schema = "aac", name = "settlement", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "cdp_settlement_id" }) })
@Entity
public class Settlement implements Comparable<Settlement> {

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

//	@Column(name = "offMarket_reference")

//java.sql.SQLException: Invalid column name 'off_market_reference'.
	private String offmarketReference;

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

	public String getAllocationPartyId() {
		return allocationPartyId;
	}

	public Settlement setAllocationPartyId(String allocationPartyId) {
		this.allocationPartyId = allocationPartyId;
		return this;
	}

	public String getCdpSettlementId() {
		return cdpSettlementId;
	}

	public Settlement setCdpSettlementId(String cdpSettlementId) {
		this.cdpSettlementId = cdpSettlementId;
		return this;
	}

	public Long getSettlementSystemId() {
		return settlementSystemId;
	}

	public Settlement setSettlementSystemId(Long settlementSystemId) {
		this.settlementSystemId = settlementSystemId;
		return this;
	}

	public Integer getSettlementStatusId() {
		return settlementStatusId;
	}

	public Settlement setSettlementStatusId(Integer settlementStatusId) {
		this.settlementStatusId = settlementStatusId;
		return this;
	}

	public Integer getPreviousValidSettlementStatusId() {
		return previousValidSettlementStatusId;
	}

	public Settlement setPreviousValidSettlementStatusId(Integer previousValidSettlementStatusId) {
		this.previousValidSettlementStatusId = previousValidSettlementStatusId;
		return this;
	}

	public SettlementStatus getSettlementStatus() {
		if (settlementStatus == null && settlementStatusId != null) {
			settlementStatus = SettlementStatus.getSettlementStatus(settlementStatusId);
		}
		return settlementStatus;
	}

	public Settlement setSettlementStatus(SettlementStatus settlementStatus) {
		Preconditions.checkNotNull(settlementStatus);
		this.settlementStatus = settlementStatus;
		this.settlementStatusId = settlementStatus.getCode();
		return this;
	}

	public SettlementStatus getPreviousValidSettlementStatus() {
		if (previousValidSettlementStatus == null && previousValidSettlementStatusId != null) {
			previousValidSettlementStatus = SettlementStatus.getSettlementStatus(previousValidSettlementStatusId);
		}
		return previousValidSettlementStatus;
	}

	public Settlement setPreviousValidSettlementStatus(SettlementStatus previousValidSettlementStatus) {
		this.previousValidSettlementStatus = previousValidSettlementStatus;

		if (previousValidSettlementStatus != null) {
			this.previousValidSettlementStatusId = previousValidSettlementStatus.getCode();
		}

		return this;
	}

	public Long getLinkedSettlementSystemId() {
		return linkedSettlementSystemId;
	}

	public Settlement setLinkedSettlementSystemId(Long linkedSettlementSystemId) {
		this.linkedSettlementSystemId = linkedSettlementSystemId;
		return this;
	}

	public String getExchangeTradeReference() {
		return exchangeTradeReference;
	}

	public Settlement setExchangeTradeReference(String exchangeTradeReference) {
		this.exchangeTradeReference = exchangeTradeReference;
		return this;
	}

	public SettlementType getSettlementType() {
		return settlementType;
	}

	public Settlement setSettlementType(SettlementType settlementType) {
		this.settlementType = settlementType;
		return this;
	}

	public EarmarkFlag getEarmarkFlag() {
		return earmarkFlag;
	}

	public Settlement setEarmarkFlag(EarmarkFlag earmarkFlag) {
		this.earmarkFlag = earmarkFlag;
		return this;
	}

	public String getOffmarketReference() {
		return offmarketReference;
	}

	public Settlement setOffmarketReference(String offmarketReference) {
		this.offmarketReference = offmarketReference;
		return this;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public Settlement setTransactionType(String transactionType) {
		this.transactionType = transactionType;
		return this;
	}

	public String getPlaceOfSettlement() {
		return placeOfSettlement;
	}

	public Settlement setPlaceOfSettlement(String placeOfSettlement) {
		this.placeOfSettlement = placeOfSettlement;
		return this;
	}

	public SafeDeliverReceive getSafeDeliverReceive() {
		return safeDeliverReceive;
	}

	public Settlement setSafeDeliverReceive(SafeDeliverReceive safeDeliverReceive) {
		this.safeDeliverReceive = safeDeliverReceive;
		return this;
	}

	public FOPDVP getFopDvp() {
		return fopDvp;
	}

	public Settlement setFopDvp(FOPDVP fopDvp) {
		this.fopDvp = fopDvp;
		return this;
	}

	public String getIsin() {
		return isin;
	}

	public Settlement setIsin(String isin) {
		this.isin = isin;
		return this;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public Settlement setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
		return this;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Settlement setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public Settlement setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public BigDecimal getAccruedInterestAmount() {
		return accruedInterestAmount;
	}

	public Settlement setAccruedInterestAmount(BigDecimal accruedInterestAmount) {
		this.accruedInterestAmount = accruedInterestAmount;
		return this;
	}

	public String getAccruedInterestAmountCurrency() {
		return accruedInterestAmountCurrency;
	}

	public Settlement setAccruedInterestAmountCurrency(String accruedInterestAmountCurrency) {
		this.accruedInterestAmountCurrency = accruedInterestAmountCurrency;
		return this;
	}

	public LocalDate getTradeDate() {
		return tradeDate;
	}

	public Settlement setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
		return this;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public Settlement setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
		return this;
	}

	public BigDecimal getDealPrice() {
		return dealPrice;
	}

	public Settlement setDealPrice(BigDecimal dealPrice) {
		this.dealPrice = dealPrice;
		return this;
	}

	public String getDealPriceCurrency() {
		return dealPriceCurrency;
	}

	public Settlement setDealPriceCurrency(String dealPriceCurrency) {
		this.dealPriceCurrency = dealPriceCurrency;
		return this;
	}

	public String getAccountOwnerId() {
		return accountOwnerId;
	}

	public Settlement setAccountOwnerId(String accountOwnerId) {
		this.accountOwnerId = accountOwnerId;
		return this;
	}

	public String getAccountOwnerIdType() {
		return accountOwnerIdType;
	}

	public Settlement setAccountOwnerIdType(String accountOwnerIdType) {
		this.accountOwnerIdType = accountOwnerIdType;
		return this;
	}

	public String getSafekeepingAccount() {
		return safekeepingAccount;
	}

	public Settlement setSafekeepingAccount(String safekeepingAccount) {
		this.safekeepingAccount = safekeepingAccount;
		return this;
	}

	public String getDepository() {
		return depository;
	}

	public Settlement setDepository(String depository) {
		this.depository = depository;
		return this;
	}

	public String getCounterpartyId() {
		return counterpartyId;
	}

	public Settlement setCounterpartyId(String counterpartyId) {
		this.counterpartyId = counterpartyId;
		return this;
	}

	public String getCounterpartyIdType() {
		return counterpartyIdType;
	}

	public Settlement setCounterpartyIdType(String counterpartyIdType) {
		this.counterpartyIdType = counterpartyIdType;
		return this;
	}

	public String getCorporateActionReference() {
		return corporateActionReference;
	}

	public Settlement setCorporateActionReference(String corporateActionReference) {
		this.corporateActionReference = corporateActionReference;
		return this;
	}

	public String getPreviousCdpSettlementSystemId() {
		return previousCdpSettlementSystemId;
	}

	public Settlement setPreviousCdpSettlementSystemId(String previousCdpSettlementSystemId) {
		this.previousCdpSettlementSystemId = previousCdpSettlementSystemId;
		return this;
	}

	public String getMatchedCdpSettlementSystemId() {
		return matchedCdpSettlementSystemId;
	}

	public Settlement setMatchedCdpSettlementSystemId(String matchedCdpSettlementSystemId) {
		this.matchedCdpSettlementSystemId = matchedCdpSettlementSystemId;
		return this;
	}

	public BigDecimal getMatchedAmount() {
		return matchedAmount;
	}

	public Settlement setMatchedAmount(BigDecimal matchedAmount) {
		this.matchedAmount = matchedAmount;
		return this;
	}

	public String getRejectedReason() {
		return rejectedReason;
	}

	public Settlement setRejectedReason(String rejectedReason) {
		this.rejectedReason = rejectedReason;
		return this;
	}

	public String getFullSettlement() {
		return fullSettlement;
	}

	public Settlement setFullSettlement(String fullSettlement) {
		this.fullSettlement = fullSettlement;
		return this;
	}

	public BigDecimal getSettledQuantity() {
		return settledQuantity;
	}

	public Settlement setSettledQuantity(BigDecimal settledQuantity) {
		this.settledQuantity = settledQuantity;
		return this;
	}

	public BigDecimal getSettledAmount() {
		return settledAmount;
	}

	public Settlement setSettledAmount(BigDecimal settledAmount) {
		this.settledAmount = settledAmount;
		return this;
	}

	public String getMicsProductKey() {
		return micsProductKey;
	}

	public Settlement setMicsProductKey(String micsProductKey) {
		this.micsProductKey = micsProductKey;
		return this;
	}

	public Settlement setMicsProductKey(AlternateProductId alternateProductId) {
//		this.micsProductKey = getMicsProductKeyFromAlterNateProductId(alternateProductId);
	    this.micsProductKey = "dummy_alternateProductId";
		return this;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Settlement setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public Settlement setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
		return this;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public Settlement setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
		return this;
	}

	public String getConfirmReason() {
		return confirmReason;
	}

	public Settlement setConfirmReason(String confirmReason) {
		this.confirmReason = confirmReason;
		return this;
	}

	public String getMicsSymbol() {
		return micsSymbol;
	}

	public Settlement setMicsSymbol(String micsSymbol) {
		this.micsSymbol = micsSymbol;
		return this;
	}

	private static Map<String, String> columnNamesToTextForCSV = new LinkedHashMap<>();
	static {
		columnNamesToTextForCSV.put("Status", "settlementStatus");
		columnNamesToTextForCSV.put("Previous Status", "previousValidSettlementStatus");
		columnNamesToTextForCSV.put("SGX Internal Setl ID", "cdpSettlementId");
		columnNamesToTextForCSV.put("ABN Internal Setl ID", "settlementSystemId");
		columnNamesToTextForCSV.put("ABN Linked Setl ID", "linkedSettlementSystemId");
		columnNamesToTextForCSV.put("SGX Trade reference", "exchangeTradeReference");
		columnNamesToTextForCSV.put("SGX Account", "allocationPartyId");
		columnNamesToTextForCSV.put("Settlement Type", "settlementType");
		columnNamesToTextForCSV.put("Earmark Flag", "earmarkFlag");
		columnNamesToTextForCSV.put("Off Market Reference", "offMarketReference");
		columnNamesToTextForCSV.put("Transaction Type", "transactionType");
		columnNamesToTextForCSV.put("Safe Deliver Receive", "safeDeliverReceive");

		columnNamesToTextForCSV.put("FOPDVP", "fopDvp");
		columnNamesToTextForCSV.put("ISIN", "isin");
		columnNamesToTextForCSV.put("MICS Symbol", "micsSymbol");
		columnNamesToTextForCSV.put("Quantity", "quantity");
		columnNamesToTextForCSV.put("Amount", "amount");

		columnNamesToTextForCSV.put("Currency", "currency");
		columnNamesToTextForCSV.put("Accrued Int Amt", "accruedInterestAmount");
		columnNamesToTextForCSV.put("Trade Date", "tradeDate");

		columnNamesToTextForCSV.put("Settlement Date", "settlementDate");
		columnNamesToTextForCSV.put("Deal Price", "dealPrice");
		columnNamesToTextForCSV.put("Deal Price Curr", "dealPriceCurrency");
		columnNamesToTextForCSV.put("Account Owner ID", "accountOwnerId");
		columnNamesToTextForCSV.put("Safekeeping Account", "safekeepingAccount");

		columnNamesToTextForCSV.put("Depository", "depository");
		columnNamesToTextForCSV.put("Ctrpty ID", "counterpartyId");
		columnNamesToTextForCSV.put("Matched Settlement ID", "matchedCdpSettlementSystemId");
		columnNamesToTextForCSV.put("Matched Amount", "matchedAmount");
		columnNamesToTextForCSV.put("Reject Reason", "rejectedReason");

		columnNamesToTextForCSV.put("Created By", "createdBy");
		columnNamesToTextForCSV.put("Verified By", "verifiedBy");
		columnNamesToTextForCSV.put("Last Update Date and Time", "lastUpdated");
	}

	/**
	 * Return csv header
	 *
	 * @return array of csv header.
	 */
	public static String[] getCsvHeaderColumns() {
		String[] a = new String[0];
		return columnNamesToTextForCSV.entrySet().stream().map(Map.Entry::getValue)
				.collect(Collectors.toCollection(LinkedList<String>::new)).toArray(a);
	}

	public static String[] getCsvHeaderText() {
		String[] a = new String[0];
		return columnNamesToTextForCSV.entrySet().stream().map(Map.Entry::getKey)
				.collect(Collectors.toCollection(LinkedList<String>::new)).toArray(a);
	}

	public static Settlement createNormalSettlement(Allocation allocation, boolean regularSettlementFlag) {
		Settlement settlement = new Settlement();

		settlement.setCdpSettlementId(null);
		settlement.setSettlementSystemId(null);

		if (regularSettlementFlag) {
			settlement.setSettlementStatus(SETTLEMENT_REQUEST_NOT_SENT);
		} else {
			settlement.setSettlementStatus(SETTLEMENT_AUTH_PENDING);
		}

		settlement.setPreviousValidSettlementStatus(null);
		settlement.setLinkedSettlementSystemId(null);
		settlement.setExchangeTradeReference(allocation.getCdpAllocationId());
		settlement.setSettlementType(NORMAL);
		settlement.setEarmarkFlag(null);
		settlement.setOffmarketReference(null);
		settlement.setTransactionType(TRANSACTION_TYPE);
		settlement.setPlaceOfSettlement(BIC_CODE_OF_CDP);
		settlement.setSafeDeliverReceive(allocation.getDirection().equalsIgnoreCase("Buy") ? DELIVER : RECEIVE);
		settlement.setFopDvp(FOPDVP.FOP);
		settlement.setIsin(allocation.getSecCode());
		settlement.setQuantity(allocation.getAllocationQuantity());
		settlement.setAmount(BigDecimal.ZERO);
		settlement.setCurrency(allocation.getSettlementCcy());
		settlement.setAccruedInterestAmount(allocation.getAllocationAccruedInterest());
		if (allocation.getAllocationAccruedInterest() != null
				&& allocation.getAllocationAccruedInterest().compareTo(BigDecimal.ZERO) != 0) {
			settlement.setAccruedInterestAmountCurrency(allocation.getTradeCcy());
		}
		settlement.setTradeDate(allocation.getTradeDate());
		settlement.setSettlementDate(allocation.getSettlementDate());
		settlement.setDealPrice(allocation.getAllocationPrice());
		settlement.setDealPriceCurrency(allocation.getTradeCcy());
		settlement.setAccountOwnerId(ABN_AMRO_ACCOUNT_OWNER_ID);
		settlement.setAccountOwnerIdType(ABN_AMRO_ACCOUNT_OWNER_ID_TYPE);
		settlement.setSafekeepingAccount(POOL_ACCOUNT_ID);
		settlement.setDepository(BIC_CODE_OF_CDP);
		settlement.setCounterpartyId(COUNTERPARTY_ID_NORMAL);
		settlement.setCounterpartyIdType(COUNTERPARTY_ID_TYPE);
		settlement.setCorporateActionReference(null);
		settlement.setPreviousCdpSettlementSystemId(null);
		settlement.setMatchedCdpSettlementSystemId(null);
		settlement.setMatchedAmount(null);
		settlement.setRejectedReason(null);
		settlement.setConfirmReason(null);
		settlement.setFullSettlement(null);
		settlement.setSettledQuantity(null);
		settlement.setSettledAmount(null);
		settlement.setMicsProductKey(allocation.getMicsProductKey());
		settlement.setMicsSymbol(allocation.getMicsSymbol());
		settlement.setCreatedBy(null);
		settlement.setVerifiedBy(null);
		settlement.setLastUpdated(LocalDateTime.now());

		return settlement;
	}

	/**
	 * @param dionSettlementNew
	 *            received from DClear.
	 * @param allocation
	 *            message for settlement new.
	 *
	 * @return new Settlement message.
	 */
	public static Settlement convert(DionSettlementNew dionSettlementNew, Allocation allocation) {

		Settlement settlement = new Settlement();

		SettlementStatus settlementStatus = SETTLEMENT_NEW_SGX;

		settlement.cdpSettlementId = dionSettlementNew.getCdpSettlementId();
		settlement.settlementStatusId = settlementStatus.getCode();
		settlement.previousValidSettlementStatusId = null;
		settlement.settlementStatus = settlementStatus;
		settlement.previousValidSettlementStatus = null;
		settlement.linkedSettlementSystemId = null;
		settlement.exchangeTradeReference = dionSettlementNew.getExchangeTradeReference();
		settlement.settlementType = NORMAL;
		settlement.earmarkFlag = EarmarkFlag.UNEARMARK;
		settlement.offmarketReference = null;
		settlement.transactionType = dionSettlementNew.getTransactionType();
		settlement.placeOfSettlement = BIC_CODE_OF_CDP;
		settlement.safeDeliverReceive = (DELIVER == SafeDeliverReceive
				.valueOf(dionSettlementNew.getSafeDeliverReceive().toUpperCase()) ? DELIVER : RECEIVE);
		settlement.fopDvp = FOPDVP.valueOf(dionSettlementNew.getFopDvp());
		settlement.isin = dionSettlementNew.getSecurityCode();
		settlement.quantity = dionSettlementNew.getQuantity();
		settlement.amount = dionSettlementNew.getAmount();
		settlement.currency = dionSettlementNew.getCurrency();
		settlement.accruedInterestAmount = (allocation != null) ? allocation.getAllocationAccruedInterest() : null;
		settlement.accruedInterestAmountCurrency = null;
		settlement.tradeDate = dionSettlementNew.getTradeDate();
		settlement.settlementDate = dionSettlementNew.getSettlementDate();
		settlement.dealPrice = null;
		settlement.dealPriceCurrency = null;
		settlement.accountOwnerId = dionSettlementNew.getAccountOwnerId();
		settlement.accountOwnerIdType = dionSettlementNew.getAccountOwnerIdType();
		settlement.safekeepingAccount = dionSettlementNew.getSafekeepingAccount();
		settlement.depository = null;
		settlement.counterpartyId = null;
		settlement.counterpartyIdType = null;
		settlement.corporateActionReference = dionSettlementNew.getCorporateActionReference();
		settlement.previousCdpSettlementSystemId = null;
		settlement.matchedCdpSettlementSystemId = null;
		settlement.matchedAmount = null;
		settlement.rejectedReason = null;
		settlement.confirmReason = null;
		settlement.fullSettlement = null;
		settlement.settledQuantity = null;
		settlement.settledAmount = null;
		settlement.createdBy = SGXPostTradeReplacementConstants.DION_MESSAGE_MAKER_ID;
		settlement.verifiedBy = SGXPostTradeReplacementConstants.DION_MESSAGE_CHECKER_ID;

		return settlement;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues().add("cdpSettlementId", cdpSettlementId)
				.add("settlementSystemId", settlementSystemId).add("settlementStatusId", settlementStatusId)
				.add("previousValidSettlementStatusId", previousValidSettlementStatusId)
				.add("settlementStatus", settlementStatus)
				.add("previousValidSettlementStatus", previousValidSettlementStatus)
				.add("linkedSettlementSystemId", linkedSettlementSystemId)
				.add("exchangeTradeReference", exchangeTradeReference).add("settlementType", settlementType)
				.add("earmarkFlag", earmarkFlag).add("offMarketReference", offmarketReference)
				.add("transactionType", transactionType).add("placeOfSettlement", placeOfSettlement)
				.add("safeDeliverReceive", safeDeliverReceive).add("fopDvp", fopDvp).add("isin", isin)
				.add("quantity", quantity).add("amount", amount).add("currency", currency)
				.add("accruedInterestAmount", accruedInterestAmount)
				.add("accruedInterestAmountCurrency", accruedInterestAmountCurrency).add("tradeDate", tradeDate)
				.add("settlementDate", settlementDate).add("dealPrice", dealPrice)
				.add("dealPriceCurrency", dealPriceCurrency).add("accountOwnerId", accountOwnerId)
				.add("accountOwnerIdType", accountOwnerIdType).add("safekeepingAccount", safekeepingAccount)
				.add("depository", depository).add("counterpartyId", counterpartyId)
				.add("counterpartyIdType", counterpartyIdType).add("corporateActionReference", corporateActionReference)
				.add("previousCdpSettlementSystemId", previousCdpSettlementSystemId)
				.add("matchedCdpSettlementSystemId", matchedCdpSettlementSystemId).add("matchedAmount", matchedAmount)
				.add("rejectedReason", rejectedReason).add("confirmReason", confirmReason)
				.add("fullSettlement", fullSettlement).add("settledQuantity", settledQuantity)
				.add("settledAmount", settledAmount).add("micsProductKey", micsProductKey).add("createdBy", createdBy)
				.add("verifiedBy", verifiedBy).add("lastUpdated", lastUpdated).toString();
	}

	public Settlement appendOrSetRejectedSettlementReason(String rejectedReasonArg) {
		String rejectedReason = this.getRejectedReason();
		String updatedRejectedReason = rejectedReason == null ? rejectedReasonArg
				: rejectedReason + (rejectedReasonArg == null ? "" : "; " + rejectedReasonArg);

		this.setRejectedReason(updatedRejectedReason);
		return this;
	}

	public Settlement appendOrSetConfirmSettlementReason(String confirmReasonArg) {
		String confirmReason = this.getConfirmReason();
		String updatedConfirmReason = confirmReason == null ? confirmReasonArg
				: confirmReason + (confirmReasonArg == null ? "" : "; " + confirmReasonArg);

		this.setConfirmReason(updatedConfirmReason);
		return this;
	}

	@Override
	public int compareTo(@NotNull Settlement that) {
		if (this == that)
			return 0;

		if (that == null || getClass() != that.getClass())
			return -1;

		if (this.micsProductKey != null) {
			if (this.micsProductKey.compareTo(that.micsProductKey) < 0) {
				return -1;
			} else if (this.micsProductKey.compareTo(that.micsProductKey) > 0) {
				return 1;
			}
		}

		if (this.fopDvp != null) {
			if (this.fopDvp.compareTo(that.fopDvp) < 0) {
				return -1;
			} else if (this.fopDvp.compareTo(that.fopDvp) > 0) {
				return 1;
			}
		}

		if (this.quantity != null) {
			if (this.quantity.compareTo(that.quantity) < 0) {
				return -1;
			} else if (this.quantity.compareTo(that.quantity) > 0) {
				return 1;
			}
		}

		if (this.settlementSystemId != null) {
			if (this.settlementSystemId.compareTo(that.settlementSystemId) < 0) {
				return -1;
			} else if (this.settlementSystemId.compareTo(that.settlementSystemId) > 0) {
				return 1;
			}
		}

		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Settlement that = (Settlement) o;

		return new EqualsBuilder().append(cdpSettlementId, that.cdpSettlementId)
				.append(settlementSystemId, that.settlementSystemId).append(settlementStatusId, that.settlementStatusId)
				.append(previousValidSettlementStatusId, that.previousValidSettlementStatusId)
				.append(settlementStatus, that.settlementStatus)
				.append(previousValidSettlementStatus, that.previousValidSettlementStatus)
				.append(linkedSettlementSystemId, that.linkedSettlementSystemId)
				.append(exchangeTradeReference, that.exchangeTradeReference).append(settlementType, that.settlementType)
				.append(earmarkFlag, that.earmarkFlag).append(offmarketReference, that.offmarketReference)
				.append(transactionType, that.transactionType).append(placeOfSettlement, that.placeOfSettlement)
				.append(safeDeliverReceive, that.safeDeliverReceive).append(fopDvp, that.fopDvp).append(isin, that.isin)
				.append(quantity, that.quantity).append(amount, that.amount).append(currency, that.currency)
				.append(accruedInterestAmount, that.accruedInterestAmount)
				.append(accruedInterestAmountCurrency, that.accruedInterestAmountCurrency)
				.append(tradeDate, that.tradeDate).append(settlementDate, that.settlementDate)
				.append(dealPrice, that.dealPrice).append(dealPriceCurrency, that.dealPriceCurrency)
				.append(accountOwnerId, that.accountOwnerId).append(accountOwnerIdType, that.accountOwnerIdType)
				.append(safekeepingAccount, that.safekeepingAccount).append(depository, that.depository)
				.append(counterpartyId, that.counterpartyId).append(counterpartyIdType, that.counterpartyIdType)
				.append(corporateActionReference, that.corporateActionReference)
				.append(previousCdpSettlementSystemId, that.previousCdpSettlementSystemId)
				.append(matchedCdpSettlementSystemId, that.matchedCdpSettlementSystemId)
				.append(matchedAmount, that.matchedAmount).append(rejectedReason, that.rejectedReason)
				.append(confirmReason, that.confirmReason).append(fullSettlement, that.fullSettlement)
				.append(settledQuantity, that.settledQuantity).append(settledAmount, that.settledAmount)
				.append(micsProductKey, that.micsProductKey).append(createdBy, that.createdBy)
				.append(verifiedBy, that.verifiedBy).append(lastUpdated, that.lastUpdated).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(cdpSettlementId).append(settlementSystemId).append(settlementStatusId)
				.append(previousValidSettlementStatusId).append(settlementStatus).append(previousValidSettlementStatus)
				.append(linkedSettlementSystemId).append(exchangeTradeReference).append(settlementType)
				.append(earmarkFlag).append(offmarketReference).append(transactionType).append(placeOfSettlement)
				.append(safeDeliverReceive).append(fopDvp).append(isin).append(quantity).append(amount).append(currency)
				.append(accruedInterestAmount).append(accruedInterestAmountCurrency).append(tradeDate)
				.append(settlementDate).append(dealPrice).append(dealPriceCurrency).append(accountOwnerId)
				.append(accountOwnerIdType).append(safekeepingAccount).append(depository).append(counterpartyId)
				.append(counterpartyIdType).append(corporateActionReference).append(previousCdpSettlementSystemId)
				.append(matchedCdpSettlementSystemId).append(matchedAmount).append(rejectedReason).append(confirmReason)
				.append(fullSettlement).append(settledQuantity).append(settledAmount).append(micsProductKey)
				.append(createdBy).append(verifiedBy).append(lastUpdated).toHashCode();
	}
}
