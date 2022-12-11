package com.thuytrang.littleflowershop.payload.request;

import com.thuytrang.littleflowershop.model.Flower;
import lombok.Data;
import lombok.ToString;
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
    
    private List<MultipartFile> pictures;

//    public List<Long> getFlowers() {
//        return flowers == null
//            ? Collections.emptyList()
//            : new ArrayList<>(this.flowers);
//    }

//    public void setFlowers(List<Long> flowerIds) {
//        if (flowerIds == null) {
//            this.flowers = null;
//        } else {
//            this.flowers = Collections.unmodifiableList(flowerIds);
//        }
//    }

//    public List<Long> getOccasionIds() {
//        return occasionIds == null
//            ? Collections.emptyList()
//            : new ArrayList<>(occasionIds);
//    }
//
//    public void setOccasionIds(List<Long> occasionIds) {
//        if (occasionIds == null) {
//            this.occasionIds = null;
//        } else {
//            this.occasionIds = Collections.unmodifiableList(occasionIds);
//        }
//    }

//    public List<MultipartFile> getProducts() {
//        return pictures == null
//            ? Collections.emptyList()
//            : new ArrayList<>(pictures);
//    }
//
//    public void setProducts(List<MultipartFile> images) {
//        if (images == null) {
//            this.pictures = null;
//        } else {
//            this.pictures = Collections.unmodifiableList(images);
//        }
//    }
}
