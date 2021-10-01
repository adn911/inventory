package com.bakhtiargalib.inventory.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Product extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "productIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "productIdGenerator", sequenceName = "product_seq", allocationSize = 1)
    private long id;

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
}
