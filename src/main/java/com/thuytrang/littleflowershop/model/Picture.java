package com.thuytrang.littleflowershop.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter @Setter(value = AccessLevel.PUBLIC)
@Table(
    name = "pictures",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "url", name = "uk_picture_url")
    }
)
public class Picture implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Picture name required")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Picture url required")
    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    private Product product;

    @Tolerate
    public Picture() { }
}