package com.thuytrang.littleflowershop.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Table(
        name = "products",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "title", name = "uk_product_title")
        }
)
public class Product extends DateAudit {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name not blank")
    @Size(min = 2, max = 100)
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 200)
    @Column(name = "description")
    private String description;

    @Column(name = "storage_life")
    private int storageLife;

    @Column(name = "dimensions")
    private String dimensions;

    @NotNull(message = "Product price not null")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @NotNull(message = "Product design style not null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_design", nullable = false)
    private Design design;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_flower",
            joinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_flower", referencedColumnName = "id"),
            uniqueConstraints = {@UniqueConstraint(
                    columnNames = {"id_product", "id_flower"}
            )}
    )
    private List<Flower> flowers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_occasion",
            joinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_occasion", referencedColumnName = "id"),
            uniqueConstraints = {@UniqueConstraint(
                    columnNames = {"id_product", "id_occasion"}
            )}
    )
    private List<Occasion> occasions;

    @OneToOne(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @PrimaryKeyJoinColumn
    private Picture picture;
}