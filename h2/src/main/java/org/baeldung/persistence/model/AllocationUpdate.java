package org.baeldung.persistence.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AllocationUpdate {


	private Long id;

	private String cdpSettlementId;

	private Long settlementSystemId;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
	    return new HashCodeBuilder()
	            .append(this.id)
	            .toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	
}
