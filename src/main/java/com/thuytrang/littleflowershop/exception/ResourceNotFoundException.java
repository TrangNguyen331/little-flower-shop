package com.thuytrang.littleflowershop.exception;

import com.thuytrang.littleflowershop.payload.response.APIResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.text.MessageFormat;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private transient APIResponse apiResponse;

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public void setApiResponse( ) {
        String message = MessageFormat.format(
            "{0} not found with {1}: {2}", this.resourceName, this.fieldName, this.fieldValue);
        this.apiResponse = APIResponse.builder()
            .success(Boolean.FALSE)
            .message(message)
            .status(HttpStatus.NOT_FOUND)
            .build();
    }

    public APIResponse getApiResponse() {
        return this.apiResponse;
    }
}
