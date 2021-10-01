package com.bakhtiargalib.inventory.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Manufacturer extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "manufacturerIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "manufacturerIdGenerator", sequenceName = "manufacturer_seq", allocationSize = 1)
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
}
