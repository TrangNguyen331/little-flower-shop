package com.thuytrang.littleflowershop.controller;

import com.thuytrang.littleflowershop.payload.request.DesignRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.DesignResponse;
import com.thuytrang.littleflowershop.service.DesignService;
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
@RequestMapping("/api/designs")
public class DesignController {
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
        @RequestBody @Validated DesignRequest body
    ) {
        System.out.println(body);
        DesignResponse response = designService.createDesign(body);

        return new ResponseEntity<>(
            response,
            HttpStatus.CREATED
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<DesignResponse> updateDesign(
        @PathVariable(name = "id") Long id,
        @RequestBody @Validated DesignRequest body
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
