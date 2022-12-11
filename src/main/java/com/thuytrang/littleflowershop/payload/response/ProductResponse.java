package com.thuytrang.littleflowershop.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thuytrang.littleflowershop.model.Design;
import com.thuytrang.littleflowershop.model.Flower;
import com.thuytrang.littleflowershop.model.Occasion;
import com.thuytrang.littleflowershop.model.Picture;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    private Long id;
    private String title;
    private String description;
    private int storageLife;
    private String dimensions;
    private BigDecimal price;
    private Design design;
    private Instant createAt;
    private List<Flower> flowers;
    private List<Occasion> occasions;
    private List<Picture> pictures;

    public String getPrice() {
        DecimalFormat formatter = new DecimalFormat("###,###,###.00");
        return formatter.format(this.price) + " VNĐ";
    }

    public String getCreateAt() {
        DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd/MM/yyyy")
            .withZone(ZoneId.systemDefault());

        return formatter.format(this.createAt);
    }
}
