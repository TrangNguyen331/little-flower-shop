package com.thuytrang.littleflowershop.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter(value = AccessLevel.PACKAGE)
@Table(name = "products")
public class Product {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "descriptions")
    private String descriptions;

    @Column(name = "storage_life")
    private int storageLife;

    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    private List<Flower> flowers;

    @Tolerate
    public Product() { }

}
