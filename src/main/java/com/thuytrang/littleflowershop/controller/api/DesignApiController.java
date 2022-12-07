package com.thuytrang.littleflowershop.controller.api;

import com.thuytrang.littleflowershop.controller.DesignControler;
import com.thuytrang.littleflowershop.payload.request.DesignRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.DesignResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Design CRUD Operation")
@RestController
@RequestMapping("/api/designs")
public class DesignApiController extends DesignControler {
    @Override
    public ResponseEntity<List<DesignResponse>> retrievalDesigns() {
        List<DesignResponse> response = designService.retrievalDesigns();

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<DesignResponse> detailDesign(Long id) {
        DesignResponse response = designService.detailDesign(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<DesignResponse> createDesign(
        @RequestBody DesignRequest body)
    {
        DesignResponse response = designService.createDesign(body);

        return new ResponseEntity<>(
            response,
            HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<DesignResponse> updateDesign(
        Long id,
        @RequestBody DesignRequest body
    ) {
        DesignResponse response = designService.updateDesign(id, body);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<APIResponse> deleteDesign(Long id) {
        APIResponse response = designService.deleteDesign(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }
}
