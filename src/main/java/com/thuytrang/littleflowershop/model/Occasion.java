package com.thuytrang.littleflowershop.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
    name = "occasions",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "title", name = "uk_occasion_title")
    }
)
public class Occasion implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Occasion title not blank")
    @Size(min = 2, max = 100)
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 200)
    @Column(name = "desciption")
    private String description;

    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "product_occasion",
        joinColumns = @JoinColumn(name = "id_occasion", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id")
    )
    private List<Product> products;
}