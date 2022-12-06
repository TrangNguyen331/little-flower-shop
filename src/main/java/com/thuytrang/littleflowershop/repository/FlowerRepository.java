package com.thuytrang.littleflowershop.repository;

import com.thuytrang.littleflowershop.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flower, Long> {
}