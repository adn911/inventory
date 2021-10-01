package com.bakhtiargalib.inventory.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Item extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "itemIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "itemIdGenerator", sequenceName = "item_seq", allocationSize = 1)
    private long id;

    @ManyToOne(optional = false)
    private Product product;

    @Column(length = 32, nullable = false, updatable = false)
    private String code;

    @Size(max = 3000)
    @Column(length = 3000)
    private String description;

    @Lob
    private byte[] image;
}
