package com.thuytrang.littleflowershop.controller;

import com.thuytrang.littleflowershop.payload.request.DesignRequest;
import com.thuytrang.littleflowershop.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public abstract class DesignControler {
    @Autowired
    protected DesignService designService;

    @GetMapping
    public abstract Object retrievalDesigns();

    @GetMapping("/{id}")
    public abstract Object detailDesign(
        @PathVariable(name = "id") Long id
    );

    @PostMapping
    public abstract Object createDesign(
        @Validated DesignRequest body
    );

    @PutMapping("/{id}")
    public abstract Object updateDesign(
        @PathVariable(name = "id") Long id,
        @Validated DesignRequest body
    );

    @DeleteMapping("/{id}")
    public abstract Object deleteDesign(
        @PathVariable(name = "id") Long id
    );
}
