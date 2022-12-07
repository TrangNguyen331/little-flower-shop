package com.thuytrang.littleflowershop.controller;

import com.thuytrang.littleflowershop.payload.request.PictureRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.PictureResponse;
import com.thuytrang.littleflowershop.service.PictureService;
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

@Tag(name = "Picture CRUD Operation")
@RestController
@RequestMapping("/api/pictures")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @GetMapping
    public ResponseEntity<List<PictureResponse>> retrievalPictures() {
        List<PictureResponse> response = pictureService.retrievalPictures();

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PictureResponse> detailPicture(
        @PathVariable(name = "id") Long id
    ) {
        PictureResponse response = pictureService.detailPicture(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<PictureResponse> createPicture(
        @RequestBody @Validated PictureRequest body
    ) {
        PictureResponse response = pictureService.createPicture(body);

        return new ResponseEntity<>(
            response,
            HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PictureResponse> updatePicture(
        @PathVariable(name = "id") Long id,
        @RequestBody @Validated PictureRequest body
    ) {
        PictureResponse response = pictureService.updatePicture(id, body);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deletePicture(
        @PathVariable(name = "id") Long id
    ) {
        APIResponse response = pictureService.deletePicture(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }
}
