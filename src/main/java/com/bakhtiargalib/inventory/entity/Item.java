package com.bakhtiargalib.inventory.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table
public class Item extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "itemIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "itemIdGenerator", sequenceName = "item_seq", allocationSize = 1)
    private long id;

    @ManyToOne(optional = false)
    private Product product;

    @Size(max = 32)
    @NotNull
    @Column(length = 32, nullable = false, updatable = false)
    private String code;

    @Size(max = 3000)
    @Column(length = 3000)
    private String description;

    @Lob
    private byte[] image;

    public Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
