package com.thuytrang.littleflowershop.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter @Setter(value = AccessLevel.PUBLIC)
@Table(
    name = "designs",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "uk_design_name")
    }
)
public class Design implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Design name required")
    @Column(name = "name")
    private String name;

    @OneToMany(
        mappedBy = "design",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Product> products;

    @Tolerate
    public Design() { }
}