package com.thuytrang.littleflowershop.controller;

import com.thuytrang.littleflowershop.payload.request.FlowerRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.FlowerResponse;
import com.thuytrang.littleflowershop.service.FlowerService;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Flower CRUD Operation")
@RestController
@RequestMapping("/api/flowers")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @GetMapping
    public ResponseEntity<List<FlowerResponse>> retrievalFlowers() {
        List<FlowerResponse> response = flowerService.retrievalFlowers();

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlowerResponse> detailFlower(
        @PathVariable(name = "id") Long id
    ) {
        FlowerResponse response = flowerService.detailFlower(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<FlowerResponse> createFlower(
        @RequestBody @Validated FlowerRequest flower
    ) {
        FlowerResponse response = flowerService.createFlower(flower);

        return new ResponseEntity<>(
            response,
            HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlowerResponse> updateFlower(
        @PathVariable(name = "id") Long id,
        @RequestBody @Validated FlowerRequest flower
    ) {
        FlowerResponse response = flowerService.updateFlower(id, flower);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteFlower(
        @PathVariable(name = "id") Long id
    ) {
        APIResponse response = flowerService.deleteFlower(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }
}
