package com.thuytrang.littleflowershop.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thuytrang.littleflowershop.model.Design;
import com.thuytrang.littleflowershop.model.Flower;
import com.thuytrang.littleflowershop.model.Occasion;
import com.thuytrang.littleflowershop.model.Picture;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    private Long id;
    private String name;
    private String descriptions;
    private int storageLife;
    private String dimensions;
    private BigDecimal price;
    private Design design;
    private List<Flower> flowers;
    private List<Occasion> occasions;
    private List<Picture> pictures;
}
