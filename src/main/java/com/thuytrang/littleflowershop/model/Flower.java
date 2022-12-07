package com.thuytrang.littleflowershop.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter @Setter(value = AccessLevel.PUBLIC)
@Table(
    name = "flowers",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"kind", "color"}, name = "uk_flower_kind_color")
    }
)
public class Flower implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Kind of flower required")
    @Column(name = "kind")
    private String kind;

    @NotNull(message = "Color of flower required")
    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private EColor color;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "product_flower",
        joinColumns = @JoinColumn(name = "id_flower", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id")
    )
    private List<Product> products;

    @Tolerate
    public Flower() { }
}