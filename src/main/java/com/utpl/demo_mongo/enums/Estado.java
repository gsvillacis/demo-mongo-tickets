package com.utpl.demo_mongo.enums;

public enum Estado {
    NUEVO("Nuevo"),
    EN_PROCESO("En Proceso"),
    RESUELTO("Resuelto");
    
    private final String displayName;
    
    Estado(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
