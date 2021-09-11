package com.bakhtiargalib.inventory.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date d) {
        created = d;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date d) {
        updated = d;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}