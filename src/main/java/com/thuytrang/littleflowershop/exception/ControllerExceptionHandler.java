package com.thuytrang.littleflowershop.exception;

import com.thuytrang.littleflowershop.payload.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> resolveException(ResourceNotFoundException exception) {
        exception.setApiResponse();
        APIResponse response = exception.getApiResponse();

        return new ResponseEntity<>(
            response,
            HttpStatus.NOT_FOUND
        );
    }
}
