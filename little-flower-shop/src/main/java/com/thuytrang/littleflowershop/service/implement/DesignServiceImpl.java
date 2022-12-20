package com.thuytrang.littleflowershop.service.implement;

import com.thuytrang.littleflowershop.exception.ResourceNotFoundException;
import com.thuytrang.littleflowershop.model.Design;
import com.thuytrang.littleflowershop.payload.request.DesignRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.DesignResponse;
import com.thuytrang.littleflowershop.repository.DesignRepository;
import com.thuytrang.littleflowershop.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
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
                    this.responseBuilder(design)
            );
        }

        return designResponses;
    }

    @Override
    public List<DesignResponse> filterDesigns(String by, String keyword) {
        List<Design> designs;

        switch (by) {
            case "id" -> {
                try {
                    designs = designRepository.findById((long) Integer.parseInt(keyword)).stream().toList();
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            case "title" -> designs = designRepository.filterByTitle(keyword);
            default -> designs = designRepository.findAll();
        }

        List<DesignResponse> designResponses = new ArrayList<>();
        for (Design design: designs) {
            designResponses.add(
                    this.responseBuilder(design)
            );
        }

        return designResponses;
    }

    @Override
    public DesignResponse detailDesign(Long id) {
        Design design = getDesignById(id);

        return this.responseBuilder(design);
    }

    @Override
    public DesignResponse createDesign(DesignRequest designRequest) {
        Design design = Design.builder()
                .title(designRequest.getTitle())
                .description(designRequest.getDescription())
                .build();

        Design newDesign = designRepository.save(design);

        return this.responseBuilder(newDesign);
    }

    @Override
    public DesignResponse updateDesign(Long id, DesignRequest designRequest) {
        Design existsDesign = getDesignById(id);

        existsDesign.setTitle(designRequest.getTitle());
        existsDesign.setDescription(designRequest.getDescription());

        Design updateDesign = designRepository.save(existsDesign);

        return responseBuilder(updateDesign);
    }

    @Override
    public APIResponse deleteDesign(Long id) {
        Design existsDesign = getDesignById(id);

        designRepository.delete(existsDesign);

        return APIResponse.builder()
                .success(Boolean.TRUE)
                .message("Design deleted success")
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

    private DesignResponse responseBuilder(Design design) {
        return DesignResponse.builder()
                .id(design.getId())
                .title(design.getTitle())
                .description(design.getDescription())
                .createdAt(design.getCreatedAtString())
                .lastModified(design.getUpdatedAtString())
                .build();
    }
}
