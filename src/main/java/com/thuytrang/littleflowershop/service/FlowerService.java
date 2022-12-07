package com.thuytrang.littleflowershop.service;

import com.thuytrang.littleflowershop.payload.request.FlowerRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.FlowerResponse;

import java.util.List;

public interface FlowerService {
    List<FlowerResponse> retrievalFlowers();
    FlowerResponse detailFlower(Long id);
    FlowerResponse createFlower(FlowerRequest flowerRequest);
    FlowerResponse updateFlower(Long id, FlowerRequest flowerRequest);
    APIResponse deleteFlower(Long id);
}