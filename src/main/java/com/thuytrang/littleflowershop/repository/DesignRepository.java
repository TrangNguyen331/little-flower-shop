package com.thuytrang.littleflowershop.repository;

import com.thuytrang.littleflowershop.model.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesignRepository extends JpaRepository<Design, Long> {
    @Query(value = "Select o FROM Design o WHERE o.title LIKE CONCAT('%',:keyword,'%')")
    List<Design> filterByTitle(
        @Param("keyword") String keyword
    );
}