package com.thuytrang.littleflowershop.controller;

import com.thuytrang.littleflowershop.model.Flower;
import com.thuytrang.littleflowershop.service.FlowerService;
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
@RequestMapping("/api/flowers")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @GetMapping
    public ResponseEntity<List<Flower>> retrievalFlowers() {
        List<Flower> response = flowerService.retrievalFlowers();

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flower> detailFlower(
        @PathVariable(name = "id") Long id
    ) {
        Flower response = flowerService.detailFlower(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Flower> saveFlower(
        @RequestBody @Validated Flower flower
    ) {
        Flower response = flowerService.saveFlower(flower);

        return new ResponseEntity<>(
            response,
            HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flower> updateFlower(
        @PathVariable(name = "id") Long id,
        @RequestBody @Validated Flower flower
    ) {
        Flower response = flowerService.updateFlower(id, flower);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlower(
        @PathVariable(name = "id") Long id
    ) {
        flowerService.deleteFlower(id);

        return new ResponseEntity<String>(
            "Delete success",
            HttpStatus.OK
        );
    }
}
