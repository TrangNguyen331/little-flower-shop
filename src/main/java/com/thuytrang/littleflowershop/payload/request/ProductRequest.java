package com.thuytrang.littleflowershop.payload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductRequest {
    @NotBlank(message = "Product name required")
    @Size(min = 2, max = 100)
    private String name;

    private String descriptions;

    private int storageLife;

    private String dimensions;

    @NotEmpty(message = "Product price required")
    private BigDecimal price;

    @NotNull(message = "Product design style required")
    private Long designId;

    private List<Long> flowerIds;

    private List<Long> occasionIds;
    
    private List<MultipartFile> images;
}
