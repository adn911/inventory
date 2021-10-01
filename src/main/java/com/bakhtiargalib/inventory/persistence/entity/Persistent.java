package com.bakhtiargalib.inventory.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class Persistent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date created;

    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date updated;

    @Version
    protected int version;

    @PrePersist
    protected void onCreate() {
        updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}