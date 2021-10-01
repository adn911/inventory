package com.bakhtiargalib.inventory.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    ACTIVE("Active"),
    DISCONTINUED("Discontinued");

    private String naturalName;
}
