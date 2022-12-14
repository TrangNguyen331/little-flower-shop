package com.thuytrang.littleflowershop.controller.api;

import com.thuytrang.littleflowershop.payload.request.DesignRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.DesignResponse;
import com.thuytrang.littleflowershop.service.DesignService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Design CRUD Operation")
@RestController
@RequestMapping("/api/designs")
public class DesignApiController {
    @Autowired
    private DesignService designService;

    @GetMapping
    public ResponseEntity<List<DesignResponse>> retrievalDesigns() {
        List<DesignResponse> response = designService.retrievalDesigns();

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesignResponse> detailDesign(
        @PathVariable(name = "id") Long id
    ) {
        DesignResponse response = designService.detailDesign(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<DesignResponse> createDesign(
        @RequestBody DesignRequest body)
    {
        DesignResponse response = designService.createDesign(body);

        return new ResponseEntity<>(
            response,
            HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesignResponse> updateDesign(
        @PathVariable(name = "id") Long id,
        @RequestBody DesignRequest body
    ) {
        DesignResponse response = designService.updateDesign(id, body);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteDesign(
        @PathVariable(name = "id") Long id
    ) {
        APIResponse response = designService.deleteDesign(id);

        return new ResponseEntity<>(
            response,
            HttpStatus.OK
        );
    }
}
