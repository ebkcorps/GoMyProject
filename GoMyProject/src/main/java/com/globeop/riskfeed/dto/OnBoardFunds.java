package com.globeop.riskfeed.dto;

public class OnBoardFunds {
	
	private String fundName;
	
	private String frequency;
	
	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "OnBoardFunds [fundName=" + fundName + ", frequency=" + frequency + "]";
	}
		
	
}
