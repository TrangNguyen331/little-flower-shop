package com.thuytrang.littleflowershop.payload.request;

import com.thuytrang.littleflowershop.model.EColor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FlowerRequest {
    @NotBlank(message = "Kind of flower required")
    private String kind;

    @NotNull(message = "Color of flower required")
    private EColor color;
}
