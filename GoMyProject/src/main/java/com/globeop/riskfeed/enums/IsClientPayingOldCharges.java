package com.globeop.riskfeed.enums;

public enum IsClientPayingOldCharges {
	
	Yes("Yes"),
	No("No");
	
	private final String displayValue;
    
    private IsClientPayingOldCharges(String displayValue) {
        this.displayValue = displayValue;
    }
     
    public String getDisplayValue() {
        return displayValue;
    }
    
    public static IsClientPayingOldCharges getEnum(String value) {
        for(IsClientPayingOldCharges v : values())
            if(v.getDisplayValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
