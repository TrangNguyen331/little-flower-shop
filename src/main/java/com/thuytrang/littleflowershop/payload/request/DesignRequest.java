package com.thuytrang.littleflowershop.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class DesignRequest {
    @NotBlank(message = "Design title required")
    @Size(min = 2, max = 100)
    private String title;

    @Size(max = 200)
    private String description;
}
