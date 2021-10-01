package com.bakhtiargalib.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    ACTIVE("Active"),
    DISCONTINUED("Discontinued");

    private String naturalName;
}
