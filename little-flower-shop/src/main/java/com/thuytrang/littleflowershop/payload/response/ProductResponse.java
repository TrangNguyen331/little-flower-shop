package com.thuytrang.littleflowershop.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.thuytrang.littleflowershop.model.Design;
import com.thuytrang.littleflowershop.model.Flower;
import com.thuytrang.littleflowershop.model.Occasion;
import com.thuytrang.littleflowershop.model.Picture;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse implements Serializable {
    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
    private int storageLife;
    private String dimensions;
    private BigDecimal price;
    private Design design;
    private String createAt;
    private String lastModified;
    private List<Flower> flowers;
    private List<Occasion> occasions;
    private Picture picture;

    public String getFormatPrice() {
        DecimalFormat formatter = new DecimalFormat("###,###,###.00");
        return formatter.format(this.price) + " VNĐ";
    }

    public String getFormatStorageLife() {
        return this.storageLife + " days";
    }
}
