package com.utpl.demo_mongo.enums;

public enum Prioridad {
    P1("P1 - Critico"),
    P2("P2 - Alto"),
    P3("P3 - Medio"),
    P4("P4 - Bajo");
    
    private final String displayName;
    
    Prioridad(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
