package com.portfolio.model;


public class GroupRequest {

	private String groupName;

    private double weightPct;

    private Double returnPct;

    private Double fallbackReturnPct;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public double getWeightPct() {
		return weightPct;
	}

	public void setWeightPct(double weightPct) {
		this.weightPct = weightPct;
	}

	public Double getReturnPct() {
		return returnPct;
	}

	public void setReturnPct(Double returnPct) {
		this.returnPct = returnPct;
	}

	public Double getFallbackReturnPct() {
		return fallbackReturnPct;
	}

	public void setFallbackReturnPct(Double fallbackReturnPct) {
		this.fallbackReturnPct = fallbackReturnPct;
	}
    
    
}
