package com.thuytrang.littleflowershop.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thuytrang.littleflowershop.model.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OccasionResponse {
    private Long id;
    private String name;
    private List<Product> products;
}