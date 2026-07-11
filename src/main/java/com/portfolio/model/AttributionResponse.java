package com.portfolio.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AttributionResponse {

	private String requestId;

    private String portfolioId;

    private LocalDate valuationDate;

    private double totalContributionPct;

    private List<GroupContribution> groupContributions;

    private String status;

    private boolean degraded;

    private List<String> warnings;

    private LocalDateTime processedAt;

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

	public double getTotalContributionPct() {
		return totalContributionPct;
	}

	public void setTotalContributionPct(double totalContributionPct) {
		this.totalContributionPct = totalContributionPct;
	}

	public List<GroupContribution> getGroupContributions() {
		return groupContributions;
	}

	public void setGroupContributions(List<GroupContribution> groupContributions) {
		this.groupContributions = groupContributions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isDegraded() {
		return degraded;
	}

	public void setDegraded(boolean degraded) {
		this.degraded = degraded;
	}

	public List<String> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<String> warnings) {
		this.warnings = warnings;
	}

	public LocalDateTime getProcessedAt() {
		return processedAt;
	}

	public void setProcessedAt(LocalDateTime processedAt) {
		this.processedAt = processedAt;
	}
    
    
}
