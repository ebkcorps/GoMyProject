package com.globeop.riskfeed.enums;

public enum AutomationProcess {
	
	RiskMQ("RiskMQ"),
	Cronjob("Cronjob");
	
	private final String displayValue;
    
    private AutomationProcess(String displayValue) {
        this.displayValue = displayValue;
    }
     
    public String getDisplayValue() {
        return displayValue;
    }
    
    public static AutomationProcess getEnum(String value) {
        for(AutomationProcess v : values())
            if(v.getDisplayValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}

