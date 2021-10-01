package com.bakhtiargalib.inventory.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Category extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "categoryIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "categoryIdGenerator", sequenceName = "category_seq", allocationSize = 1)
    private long id;

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
