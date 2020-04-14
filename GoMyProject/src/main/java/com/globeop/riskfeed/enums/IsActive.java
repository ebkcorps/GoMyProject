package com.globeop.riskfeed.enums;

public enum IsActive {
	
	Active("Active"),
	InActive("InActive");
	
	private final String displayValue;
    
    private IsActive(String displayValue) {
        this.displayValue = displayValue;
    }
     
    public String getDisplayValue() {
        return displayValue;
    }
    
    public static IsActive getEnum(String value) {
        for(IsActive v : values())
            if(v.getDisplayValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
