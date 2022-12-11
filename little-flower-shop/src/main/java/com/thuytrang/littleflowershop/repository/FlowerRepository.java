package com.thuytrang.littleflowershop.repository;

import com.thuytrang.littleflowershop.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlowerRepository extends JpaRepository<Flower, Long> {
    @Query(value = "Select o FROM Flower o WHERE o.kind LIKE CONCAT('%',:keyword,'%')")
    List<Flower> filterByKind(
        @Param("keyword") String keyword
    );

    @Query(value = "Select o FROM Flower o WHERE o.color LIKE CONCAT('%',:keyword,'%')")
    List<Flower> filterByColor(
        @Param("keyword") String keyword
    );
}