package com.thuytrang.littleflowershop.controller.api;

import com.thuytrang.littleflowershop.controller.ProductController;
import com.thuytrang.littleflowershop.payload.request.ProductRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.ProductResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Product CRUD Operation")
@RestController
@RequestMapping("/api/products")
public class ProductApiController extends ProductController {
    @Override
    public ResponseEntity<List<ProductResponse>> retrievalProducts() {
        List<ProductResponse> response = productService.retrievalProducts();

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<ProductResponse> detailProduct(Long id) {
        ProductResponse response = productService.detailProduct(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<ProductResponse> createProduct(
        @RequestBody ProductRequest body
    ) {
        ProductResponse response = productService.createProduct(body);

        return new ResponseEntity<>(
            response,
            HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<ProductResponse> updateProduct(
        Long id,
        @RequestBody ProductRequest body
    ) {
        ProductResponse response = productService.updateProduct(id, body);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<APIResponse> deleteProduct(Long id) {
        APIResponse response = productService.deleteProduct(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }
}
