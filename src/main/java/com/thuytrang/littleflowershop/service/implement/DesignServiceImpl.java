package com.thuytrang.littleflowershop.service.implement;

import com.thuytrang.littleflowershop.exception.ResourceNotFoundException;
import com.thuytrang.littleflowershop.model.Design;
import com.thuytrang.littleflowershop.payload.request.DesignRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.DesignResponse;
import com.thuytrang.littleflowershop.repository.DesignRepository;
import com.thuytrang.littleflowershop.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DesignServiceImpl implements DesignService {
    @Autowired
    private DesignRepository designRepository;

    @Override
    public List<DesignResponse> retrievalDesigns() {
        List<Design> designs = designRepository.findAll();

        List<DesignResponse> designResponses = new ArrayList<>();
        for (Design design: designs) {
            designResponses.add(
                DesignResponse.builder()
                    .id(design.getId())
                    .name(design.getName())
                    .products(design.getProducts())
                    .build()
            );
        }

        return designResponses;
    }

    @Override
    public DesignResponse detailDesign(Long id) {
        Design design = getDesignById(id);

        return DesignResponse.builder()
            .id(design.getId())
            .name(design.getName())
            .products(design.getProducts())
            .build();
    }

    @Override
    public DesignResponse createDesign(DesignRequest designRequest) {
        Design design = Design.builder()
            .name(designRequest.getName())
            .build();

        Design newDesign = designRepository.save(design);

        return DesignResponse.builder()
            .id(newDesign.getId())
            .name(newDesign.getName())
            .build();
    }

    @Override
    public DesignResponse updateDesign(Long id, DesignRequest designRequest) {
        Design existsDesign = getDesignById(id);

        existsDesign.setName(designRequest.getName());
        Design updateDesign = designRepository.save(existsDesign);

        return DesignResponse.builder()
            .id(updateDesign.getId())
            .name(updateDesign.getName())
            .products(updateDesign.getProducts())
            .build();
    }

    @Override
    public APIResponse deleteDesign(Long id) {
        Design existsDesign = getDesignById(id);

        designRepository.delete(existsDesign);

        return APIResponse.builder()
            .success(Boolean.TRUE)
            .message("Design deleted success")
            .status(HttpStatus.OK)
            .build();
    }

    private Design getDesignById(Long id) {
        return designRepository
            .findById(id)
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Design")
                    .fieldName("ID")
                    .fieldValue(id)
                    .build()
            );
    }
}
