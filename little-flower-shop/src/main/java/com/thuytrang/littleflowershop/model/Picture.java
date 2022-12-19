package com.thuytrang.littleflowershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Table(
        name = "pictures",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name", "url"}, name = "uk_flower_kind_color")
        }
)
public class Picture implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Picture name not blank")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Picture url not blank")
    @Column(name = "url")
    private String url;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;
}