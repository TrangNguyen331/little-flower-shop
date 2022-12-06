package com.thuytrang.littleflowershop.payload.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class DesignRequest {
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;
}
