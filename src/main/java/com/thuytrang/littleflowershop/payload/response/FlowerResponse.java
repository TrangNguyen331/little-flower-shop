package com.thuytrang.littleflowershop.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thuytrang.littleflowershop.model.EColor;
import com.thuytrang.littleflowershop.model.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlowerResponse {
    private Long id;
    private String kind;
    private EColor color;
    private List<Product> products;
}
