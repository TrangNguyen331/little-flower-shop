package com.thuytrang.littleflowershop.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class OccasionRequest {
    @NotBlank(message = "Occasion name required")
    @Size(min = 2, max = 10)
    private String name;
}
