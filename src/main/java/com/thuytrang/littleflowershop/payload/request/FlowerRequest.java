package com.thuytrang.littleflowershop.payload.request;

import com.thuytrang.littleflowershop.model.EColor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class FlowerRequest {
    @NotBlank(message = "Kind of flower not blank")
    @Size(min = 2, max = 100)
    private String kind;

    @NotNull(message = "Color of flower not null")
    private EColor color;

    @Size(max = 200)
    private String description;
}
