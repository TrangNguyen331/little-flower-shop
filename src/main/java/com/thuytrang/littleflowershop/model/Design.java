package com.thuytrang.littleflowershop.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
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
    name = "designs",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "title", name = "uk_design_title")
    }
)
public class Design implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Design title not blank")
    @Size(min = 2, max = 100)
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 200)
    @Column(name = "description")
    private String description;

    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createAt;

    @OneToMany(
        mappedBy = "design",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Product> products;
}