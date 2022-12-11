package com.thuytrang.littleflowershop.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thuytrang.littleflowershop.model.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PictureResponse {
    private Long id;
    private String name;
    private String url;
    private Product product;
}
