package com.thuytrang.littleflowershop.service;

import com.thuytrang.littleflowershop.payload.request.ProductRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> retrievalProducts();
    List<ProductResponse> filterProducts(String by, String keyword);
    ProductResponse detailProduct(Long id);
    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse updateProduct(Long id, ProductRequest productRequest);
    APIResponse deleteProduct(Long id);
}
