package com.thuytrang.littleflowershop.service;

import com.thuytrang.littleflowershop.payload.request.DesignRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.DesignResponse;

import java.util.List;

public interface DesignService {
    List<DesignResponse> retrievalDesigns();
    DesignResponse detailDesign(Long id);
    DesignResponse createDesign(DesignRequest designRequest);
    DesignResponse updateDesign(Long id, DesignRequest designRequest);
    APIResponse deleteDesign(Long id);
}