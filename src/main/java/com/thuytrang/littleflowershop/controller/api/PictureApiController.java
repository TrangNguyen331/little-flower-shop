package com.thuytrang.littleflowershop.controller.api;

import com.thuytrang.littleflowershop.controller.PictureController;
import com.thuytrang.littleflowershop.payload.request.PictureRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.PictureResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Picture CRUD Operation")
@RestController
@RequestMapping("/api/pictures")
public class PictureApiController extends PictureController {
    @Override
    public ResponseEntity<List<PictureResponse>> retrievalPictures() {
        List<PictureResponse> response = pictureService.retrievalPictures();

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<PictureResponse> detailPicture(Long id) {
        PictureResponse response = pictureService.detailPicture(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<PictureResponse> createPicture(
        @RequestBody PictureRequest body
    ) {
        PictureResponse response = pictureService.createPicture(body);

        return new ResponseEntity<>(
            response,
            HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<PictureResponse> updatePicture(
        Long id,
        @RequestBody PictureRequest body
    ) {
        PictureResponse response = pictureService.updatePicture(id, body);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<APIResponse> deletePicture(Long id) {
        APIResponse response = pictureService.deletePicture(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }
}
