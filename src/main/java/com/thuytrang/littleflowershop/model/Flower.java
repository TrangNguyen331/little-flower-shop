package com.thuytrang.littleflowershop.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Builder
@Getter @Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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

    @NotBlank(message = "Kind of flower not blank")
    @Size(min = 2, max = 100)
    @Column(name = "kind", nullable = false)
    private String kind;

    @NotNull(message = "Color of flower not null")
    @Enumerated(EnumType.STRING)
    @Column(name = "color", nullable = false)
    private EColor color;

    @Size(max = 200)
    @Column(name = "description")
    private String description;

    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "product_flower",
        joinColumns = @JoinColumn(name = "id_flower", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id")
    )
    private List<Product> products;
}