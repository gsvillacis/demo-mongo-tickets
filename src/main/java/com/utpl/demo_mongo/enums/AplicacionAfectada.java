package com.utpl.demo_mongo.enums;

public enum AplicacionAfectada {
    BANCA_MOVIL("Banca Movil"),
    BANCA_WEB("Banca Web"),
    CASH("Cash"),
    BIZAGI("Bizagi"),
    WEBTELLER("Webteller");
    
    private final String displayName;
    
    AplicacionAfectada(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
