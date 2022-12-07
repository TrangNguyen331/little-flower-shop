package com.thuytrang.littleflowershop.controller;

import com.thuytrang.littleflowershop.payload.request.OccasionRequest;
import com.thuytrang.littleflowershop.service.OccasionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public abstract class OccasionController {
    @Autowired
    protected OccasionService occasionService;

    @GetMapping
    public abstract Object retrievalOccasions();

    @GetMapping("/{id}")
    public abstract Object detailOccasion(
        @PathVariable(name = "id") Long id
    );

    @PostMapping
    public abstract Object createOccasion(
        @Validated OccasionRequest body
    );

    @PutMapping("/{id}")
    public abstract Object updateOccasion(
        @PathVariable(name = "id") Long id,
        @Validated OccasionRequest body
    );

    @DeleteMapping("/{id}")
    public abstract Object deleteOccasion(
        @PathVariable(name = "id") Long id
    );
}
