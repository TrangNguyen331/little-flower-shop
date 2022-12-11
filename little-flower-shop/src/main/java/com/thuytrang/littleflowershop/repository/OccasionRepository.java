package com.thuytrang.littleflowershop.repository;

import com.thuytrang.littleflowershop.model.Occasion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OccasionRepository extends JpaRepository<Occasion, Long> {
    @Query(value = "Select o FROM Occasion o WHERE o.title LIKE CONCAT('%',:keyword,'%')")
    List<Occasion> filterByTitle(
        @Param("keyword") String keyword
    );
}
