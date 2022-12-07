package com.thuytrang.littleflowershop.service;

import com.thuytrang.littleflowershop.payload.request.OccasionRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.OccasionResponse;

import java.util.List;

public interface OccasionService {
    List<OccasionResponse> retrievalOccasions();
    OccasionResponse detailOccasion(Long id);
    OccasionResponse createOccasion(OccasionRequest occasionRequest);
    OccasionResponse updateOccasion(Long id, OccasionRequest occasionRequest);
    APIResponse deleteOccasion(Long id);
}
