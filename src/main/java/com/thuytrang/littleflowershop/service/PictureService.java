package com.thuytrang.littleflowershop.service;

import com.thuytrang.littleflowershop.payload.request.PictureRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.PictureResponse;

import java.util.List;

public interface PictureService {
    List<PictureResponse> retrievalPictures();
    PictureResponse detailPicture(Long id);
    PictureResponse createPicture(PictureRequest pictureRequest);
    PictureResponse updatePicture(Long id, PictureRequest pictureRequest);
    APIResponse deletePicture(Long id);
}
