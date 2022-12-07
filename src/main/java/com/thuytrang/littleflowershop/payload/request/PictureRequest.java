package com.thuytrang.littleflowershop.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PictureRequest {
    @NotBlank(message = "Picture name required")
    private String name;

    @NotBlank(message = "Picture url required")
    private String url;

    @NotNull(message = "Product for this image required")
    private Long productId;
}
