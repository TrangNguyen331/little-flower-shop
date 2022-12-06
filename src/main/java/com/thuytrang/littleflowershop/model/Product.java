package com.thuytrang.littleflowershop.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter @Setter(value = AccessLevel.PACKAGE)
@ToString
@EqualsAndHashCode
@Table(name = "products")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name required")
    @Column(name = "name")
    private String name;

    @Column(name = "descriptions")
    private String descriptions;

    @Column(name = "storage_life")
    private int storageLife;

    @Column(name = "dimensions")
    private String dimensions;

    @NotEmpty(message = "Product price required")
    @Column(name = "price")
    private BigDecimal price;

    @NotNull(message = "Product design style required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_design")
    private Design design;

    @ManyToMany(mappedBy = "products")
    private List<Flower> flowers;

    @ManyToMany(mappedBy = "products")
    private List<Occasion> occasions;

    @OneToMany(
        mappedBy = "product",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Picture> pictures;

    @Tolerate
    public Product() { }
}