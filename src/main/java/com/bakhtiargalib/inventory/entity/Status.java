package com.bakhtiargalib.inventory.entity;

public enum Status {
    ACTIVE("Active"),
    DISCONTINUED("Discontinued");

    private String naturalName;

    Status(String naturalName) {
        this.naturalName = naturalName;
    }

    public String getNaturalName() {
        return naturalName;
    }

    public void setNaturalName(String naturalName) {
        this.naturalName = naturalName;
    }
}
