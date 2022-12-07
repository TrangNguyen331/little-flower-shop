package com.thuytrang.littleflowershop.controller;

import com.thuytrang.littleflowershop.payload.request.FlowerRequest;
import com.thuytrang.littleflowershop.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public abstract class FlowerController {
    @Autowired
    protected FlowerService flowerService;

    @GetMapping
    public abstract Object retrievalFlowers();

    @GetMapping("/{id}")
    public abstract Object detailFlower(
        @PathVariable(name = "id") Long id
    );

    @PostMapping
    public abstract Object createFlower(
        @Validated FlowerRequest body
    );

    @PutMapping("/{id}")
    public abstract Object updateFlower(
        @PathVariable(name = "id") Long id,
        @Validated FlowerRequest body
    );

    @DeleteMapping("/{id}")
    public abstract Object deleteFlower(
        @PathVariable(name = "id") Long id
    );
}
