package com.bakhtiargalib.inventory.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table
public class Manufacturer extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "manufacturerIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "manufacturerIdGenerator", sequenceName = "manufacturer_seq", allocationSize = 1)
    private long id;

    @Size(max = 32)
    @Column(length = 32, nullable = false, updatable = false)
    private String code;

    @Size(max = 255)
    @NotNull
    @Column(length = 255, nullable = false)
    private String title;

    @Size(max = 3000)
    @Column(length = 3000)
    private String description;

    @Lob
    private byte[] image;

    public Manufacturer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer manufacturer = (Manufacturer) o;
        return id == manufacturer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
