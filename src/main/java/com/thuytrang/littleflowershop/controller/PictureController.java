package com.thuytrang.littleflowershop.controller;

import com.thuytrang.littleflowershop.payload.request.PictureRequest;
import com.thuytrang.littleflowershop.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public abstract class PictureController {
    @Autowired
    protected PictureService pictureService;

    @GetMapping
    public abstract Object retrievalPictures();

    @GetMapping("/{id}")
    public abstract Object detailPicture(
        @PathVariable(name = "id") Long id
    );

    @PostMapping
    public abstract Object createPicture(
        @Validated PictureRequest body
    );

    @PutMapping("/{id}")
    public abstract Object updatePicture(
        @PathVariable(name = "id") Long id,
        @Validated PictureRequest body
    );

    @DeleteMapping("/{id}")
    public abstract Object deletePicture(
        @PathVariable(name = "id") Long id
    );
}
