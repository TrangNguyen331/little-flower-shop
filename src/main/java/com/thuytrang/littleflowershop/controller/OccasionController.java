package com.thuytrang.littleflowershop.controller;

import com.thuytrang.littleflowershop.payload.request.OccasionRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.OccasionResponse;
import com.thuytrang.littleflowershop.service.OccasionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/occasions")
public class OccasionController {
    @Autowired
    private OccasionService occasionService;

    @GetMapping
    public ResponseEntity<List<OccasionResponse>> retrievalOccasions() {
        List<OccasionResponse> response = occasionService.retrievalOccasions();

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<OccasionResponse> detailOccasion(
        @PathVariable(name = "id") Long id
        ) {
        OccasionResponse response = occasionService.detailOccasion(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<OccasionResponse> createOccasion(
        @RequestBody @Validated OccasionRequest body
    ) {
        OccasionResponse response = occasionService.createOccasion(body);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<OccasionResponse> updateOccasion(
        @PathVariable(name = "id") Long id,
        @RequestBody @Validated OccasionRequest body
    ) {
        OccasionResponse response = occasionService.updateOccasion(id, body);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteOccasion(
        @PathVariable(name = "id") Long id
    ) {
        APIResponse response = occasionService.deleteOccasion(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }
}
