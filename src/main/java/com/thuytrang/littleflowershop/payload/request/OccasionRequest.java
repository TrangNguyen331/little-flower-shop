package com.thuytrang.littleflowershop.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class OccasionRequest {
    @NotBlank(message = "Occasion name not blank")
    @Size(min = 2, max = 100)
    private String title;

    @Size(max = 200)
    private String description;
}
