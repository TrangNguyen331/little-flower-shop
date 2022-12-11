package com.thuytrang.littleflowershop.payload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
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

    private List<Long> flowerIds;

    private List<Long> occasionIds;
    
    private List<MultipartFile> images;

    public List<Long> getFlowerIds() {
        return flowerIds == null
            ? Collections.emptyList()
            : new ArrayList<>(flowerIds);
    }

    public void setFlowerIds(List<Long> flowerIds) {
        if (flowerIds == null) {
            this.flowerIds = null;
        } else {
            this.flowerIds = Collections.unmodifiableList(flowerIds);
        }
    }

    public List<Long> getOccasionIds() {
        return occasionIds == null
            ? Collections.emptyList()
            : new ArrayList<>(occasionIds);
    }

    public void setOccasionIds(List<Long> occasionIds) {
        if (occasionIds == null) {
            this.occasionIds = null;
        } else {
            this.occasionIds = Collections.unmodifiableList(occasionIds);
        }
    }

    public List<MultipartFile> getImages() {
        return images == null
            ? Collections.emptyList()
            : new ArrayList<>(images);
    }

    public void setImages(List<MultipartFile> images) {
        if (images == null) {
            this.images = null;
        } else {
            this.images = Collections.unmodifiableList(images);
        }
    }
}
