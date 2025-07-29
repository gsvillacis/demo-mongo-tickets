package com.utpl.demo_mongo.enums;

public enum GrupoResolutor {
    BP_WINTEL("BP_Wintel"),
    BP_UNIX("BP_Unix"),
    BP_BDD("BP_BDD"),
    BP_BANCA_MOVIL("BP_Banca_Movil"),
    BP_BANCA_WEB("BP_Banca_Web"),
    BP_BIZAGI("BP_Bizagi"),
    BP_CASH("BP_Cash");
    
    private final String displayName;
    
    GrupoResolutor(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
