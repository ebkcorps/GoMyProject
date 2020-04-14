package com.globeop.riskfeed.enums;

public enum IsWaivedOff {

	Yes("Yes"),
	No("No");
	
	private final String displayValue;
    
    private IsWaivedOff(String displayValue) {
        this.displayValue = displayValue;
    }
     
    public String getDisplayValue() {
        return displayValue;
    }
    
    public static IsWaivedOff getEnum(String value) {
        for(IsWaivedOff v : values())
            if(v.getDisplayValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
