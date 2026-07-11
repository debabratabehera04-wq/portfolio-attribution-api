package com.portfolio.model;

import java.time.LocalDate;
import java.util.List;


public class AttributionRequest {

	private String requestId;
    private String portfolioId;
    private LocalDate valuationDate;

    private List<GroupRequest> groups;

    private String currency;
    private String requestedBy;
    
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}
	public LocalDate getValuationDate() {
		return valuationDate;
	}
	public void setValuationDate(LocalDate valuationDate) {
		this.valuationDate = valuationDate;
	}
	public List<GroupRequest> getGroups() {
		return groups;
	}
	public void setGroups(List<GroupRequest> groups) {
		this.groups = groups;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
    
    
}
