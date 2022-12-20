package com.thuytrang.littleflowershop.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DesignResponse implements Serializable {
    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
    private String createdAt;
    private String lastModified;
}
