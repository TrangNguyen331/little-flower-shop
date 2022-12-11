package com.thuytrang.littleflowershop.repository;

import com.thuytrang.littleflowershop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "Select o FROM Product o WHERE o.title LIKE CONCAT('%',:keyword,'%')")
    List<Product> filterByTitle(
        @Param("keyword") String keyword
    );

    @Query(value = "Select o FROM Product o WHERE o.design LIKE CONCAT('%',:keyword,'%')")
    List<Product> filterByDesign(
        @Param("keyword") String keyword
    );
}
