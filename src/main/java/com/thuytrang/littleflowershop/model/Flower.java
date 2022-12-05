package com.thuytrang.littleflowershop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(of = {"kind", "color"})
@Entity
@Table(name = "flowers")
public class Flower {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kind")
    private String kind;

    @Column(name = "color")
    private String color;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

}
