package com.thuytrang.littleflowershop.controller.api;

import com.thuytrang.littleflowershop.controller.OccasionController;
import com.thuytrang.littleflowershop.payload.request.OccasionRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.OccasionResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Occasion CRUD Operation")
@RestController
@RequestMapping("/api/occasions")
public class OccasionApiController extends OccasionController {
    @Override
    public ResponseEntity<List<OccasionResponse>> retrievalOccasions() {
        List<OccasionResponse> response = occasionService.retrievalOccasions();

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<OccasionResponse> detailOccasion(Long id) {
        OccasionResponse response = occasionService.detailOccasion(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<OccasionResponse> createOccasion(
        @RequestBody OccasionRequest body
    ) {
        OccasionResponse response = occasionService.createOccasion(body);

        return new ResponseEntity<>(
            response,
            HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<OccasionResponse> updateOccasion(
        Long id,
        @RequestBody OccasionRequest body
    ) {
        OccasionResponse response = occasionService.updateOccasion(id, body);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<APIResponse> deleteOccasion(Long id) {
        APIResponse response = occasionService.deleteOccasion(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }
}
