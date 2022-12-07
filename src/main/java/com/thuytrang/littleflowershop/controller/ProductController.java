package com.thuytrang.littleflowershop.controller;

import com.thuytrang.littleflowershop.model.Product;
import com.thuytrang.littleflowershop.payload.request.ProductRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.ProductResponse;
import com.thuytrang.littleflowershop.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Product CRUD Operation")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> retrievalProducts() {
        List<ProductResponse> response = productService.retrievalProducts();

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> detailProduct(
        @PathVariable(name = "id") Long id
    ) {
        ProductResponse response = productService.detailProduct(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
        @RequestBody @Validated ProductRequest body
    ) {
        ProductResponse response = productService.createProduct(body);

        return new ResponseEntity<>(
            response,
            HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
        @PathVariable(name = "id") Long id,
        @RequestBody @Validated ProductRequest body
    ) {
        ProductResponse response = productService.updateProduct(id, body);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteProduct(
        @PathVariable(name = "id") Long id
    ) {
        APIResponse response = productService.deleteProduct(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }
}
