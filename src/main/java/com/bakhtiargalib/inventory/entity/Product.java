package com.bakhtiargalib.inventory.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class Product extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "productIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "productIdGenerator", sequenceName = "product_seq", allocationSize = 1)
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

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 32, nullable = false)
    private Status status;

    private BigDecimal unitPrice;

    @JoinColumn(nullable = false)
    @ManyToOne(optional = false)
    private Manufacturer manufacturer;

    @JoinColumn(nullable = false)
    @ManyToOne(optional = false)
    private Category category;

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
