package com.thuytrang.littleflowershop.payload.request;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
public class ProductRequest {
    @NotBlank(message = "Product name not blank")
    @Size(min = 2, max = 100)
    private String title;

    @Size(max = 200)
    private String description;

    private int storageLife;

    private String dimensions;

    @NotNull(message = "Product price not null")
    private BigDecimal price;

    @NotNull(message = "Product design style not null")
    private Long designId;

    private List<Long> flowers;

    private List<Long> occasions;

    private MultipartFile picture;
}
