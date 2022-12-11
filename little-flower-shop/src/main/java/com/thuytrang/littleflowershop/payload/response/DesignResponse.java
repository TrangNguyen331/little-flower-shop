package com.thuytrang.littleflowershop.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thuytrang.littleflowershop.model.Product;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DesignResponse {
    private Long id;
    private String title;
    private String description;
    private Instant createAt;
    private List<Product> products;

    public String getCreateAt() {
        DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd/MM/yyyy")
            .withZone(ZoneId.systemDefault());

        return formatter.format(this.createAt);
    }
}
