package com.thuytrang.littleflowershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
import javax.validation.constraints.Size;
import java.io.Serial;
import java.util.List;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Table(
        name = "designs",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "title", name = "uk_design_title")
        }
)
public class Design extends DateAudit {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Design title not blank")
    @Size(min = 2, max = 100)
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Size(max = 200)
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(
            mappedBy = "design",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Product> products;
}