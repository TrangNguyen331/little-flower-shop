package com.thuytrang.littleflowershop.controller.api;

import com.thuytrang.littleflowershop.controller.FlowerController;
import com.thuytrang.littleflowershop.payload.request.FlowerRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.FlowerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Flower CRUD Operation")
@RestController
@RequestMapping("/api/flowers")
public class FlowerApiController extends FlowerController {
    @Override
    public ResponseEntity<List<FlowerResponse>> retrievalFlowers() {
        List<FlowerResponse> response = flowerService.retrievalFlowers();

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<FlowerResponse> detailFlower(Long id) {
        FlowerResponse response = flowerService.detailFlower(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<FlowerResponse> createFlower(
        @RequestBody FlowerRequest body
    ) {
        FlowerResponse response = flowerService.createFlower(body);

        return new ResponseEntity<>(
            response,
            HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<FlowerResponse> updateFlower(
        Long id,
        @RequestBody FlowerRequest body
    ) {
        FlowerResponse response = flowerService.updateFlower(id, body);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<APIResponse> deleteFlower(Long id) {
        APIResponse response = flowerService.deleteFlower(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }
}
