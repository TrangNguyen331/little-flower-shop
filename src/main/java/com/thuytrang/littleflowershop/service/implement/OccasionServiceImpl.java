package com.thuytrang.littleflowershop.service.implement;

import com.thuytrang.littleflowershop.exception.ResourceNotFoundException;
import com.thuytrang.littleflowershop.model.Occasion;
import com.thuytrang.littleflowershop.payload.request.OccasionRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.OccasionResponse;
import com.thuytrang.littleflowershop.repository.OccasionRepository;
import com.thuytrang.littleflowershop.service.OccasionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OccasionServiceImpl implements OccasionService {
    @Autowired
    private OccasionRepository occasionRepository;

    @Override
    public List<OccasionResponse> retrievalOccasions() {
        List<Occasion> occasions = occasionRepository.findAll();

        List<OccasionResponse> occasionResponses = new ArrayList<>();
        for (Occasion occasion: occasions) {
            occasionResponses.add(
                OccasionResponse.builder()
                    .id(occasion.getId())
                    .name(occasion.getName())
                    .products(occasion.getProducts())
                    .build()
            );
        }

        return occasionResponses;
    }

    @Override
    public OccasionResponse detailOccasion(Long id) {
        Occasion occasion = getOccasionById(id);

        return OccasionResponse.builder()
            .id(occasion.getId())
            .name(occasion.getName())
            .products(occasion.getProducts())
            .build();
    }

    @Override
    public OccasionResponse createOccasion(OccasionRequest occasionRequest) {
        Occasion occasion = Occasion.builder()
            .name(occasionRequest.getName())
            .build();

        Occasion newOccasion = occasionRepository.save(occasion);

        return OccasionResponse.builder()
            .id(newOccasion.getId())
            .name(newOccasion.getName())
            .build();
    }

    @Override
    public OccasionResponse updateOccasion(Long id, OccasionRequest occasionRequest) {
        Occasion existsOccasion = getOccasionById(id);

        existsOccasion.setName(occasionRequest.getName());
        Occasion updateOccasion = occasionRepository.save(existsOccasion);

        return OccasionResponse.builder()
            .id(updateOccasion.getId())
            .name(updateOccasion.getName())
            .products(updateOccasion.getProducts())
            .build();
    }

    @Override
    public APIResponse deleteOccasion(Long id) {
        Occasion existsOccasion = getOccasionById(id);

        occasionRepository.delete(existsOccasion);

        return APIResponse.builder()
            .success(Boolean.TRUE)
            .message("Occasion deleted success")
            .build();
    }

    private Occasion getOccasionById(Long id) {
        return occasionRepository
            .findById(id)
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Occasion")
                    .fieldName("ID")
                    .fieldValue(id)
                    .build()
            );
    }
}
