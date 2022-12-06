package com.thuytrang.littleflowershop.repository;

import com.thuytrang.littleflowershop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
