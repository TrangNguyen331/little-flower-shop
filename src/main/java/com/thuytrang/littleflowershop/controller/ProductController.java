package com.thuytrang.littleflowershop.controller;

import com.thuytrang.littleflowershop.payload.request.ProductRequest;
import com.thuytrang.littleflowershop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public abstract class ProductController {
    @Autowired
    protected ProductService productService;

    @GetMapping
    public abstract Object retrievalProducts();

    @GetMapping("/{id}")
    public abstract Object detailProduct(
        @PathVariable(name = "id") Long id
    );

    @PostMapping
    public abstract Object createProduct(
        @Validated ProductRequest body
    );

    @PutMapping("/{id}")
    public abstract Object updateProduct(
        @PathVariable(name = "id") Long id,
        @Validated ProductRequest body
    );

    @DeleteMapping("/{id}")
    public abstract Object deleteProduct(
        @PathVariable(name = "id") Long id
    );
}
