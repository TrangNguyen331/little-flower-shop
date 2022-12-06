package com.thuytrang.littleflowershop.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thuytrang.littleflowershop.model.Product;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DesignResponse {
    private Long id;
    private String name;
    private List<Product> products;

    public List<Product> getProducts() {
        return this.products == null
            ? null
            : new ArrayList<>(products);
    }

    public void setProducts(List<Product> products) {
        if (products == null) {
            this.products = null;
        } else {
            this.products = Collections.unmodifiableList(products);
        }
    }
}
