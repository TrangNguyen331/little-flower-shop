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
import java.util.Objects;

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
                this.responseBuilder(occasion)
            );
        }

        return occasionResponses;
    }

    @Override
    public List<OccasionResponse> filterOccasions(String by, String keyword) {
        List<Occasion> occasions;

        if (Objects.equals(by, "id")) {
            try {
                occasions = occasionRepository.findById((long) Integer.parseInt(keyword)).stream().toList();
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            occasions = occasionRepository.filterByTitle(keyword);
        }

        List<OccasionResponse> occasionResponses = new ArrayList<>();
        for (Occasion occasion: occasions) {
            occasionResponses.add(
                this.responseBuilder(occasion)
            );
        }

        return occasionResponses;
    }

    @Override
    public OccasionResponse detailOccasion(Long id) {
        Occasion occasion = getOccasionById(id);

        return this.responseBuilder(occasion);
    }

    @Override
    public OccasionResponse createOccasion(OccasionRequest occasionRequest) {
        Occasion occasion = Occasion.builder()
            .title(occasionRequest.getTitle())
            .description(occasionRequest.getDescription())
            .build();

        Occasion newOccasion = occasionRepository.save(occasion);

        return responseBuilder(newOccasion);
    }

    @Override
    public OccasionResponse updateOccasion(Long id, OccasionRequest occasionRequest) {
        Occasion existsOccasion = getOccasionById(id);

        existsOccasion.setTitle(occasionRequest.getTitle());
        existsOccasion.setDescription(occasionRequest.getDescription());

        Occasion updateOccasion = occasionRepository.save(existsOccasion);

        return responseBuilder(updateOccasion);
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

    private OccasionResponse responseBuilder(Occasion occasion) {
        return OccasionResponse.builder()
            .id(occasion.getId())
            .title(occasion.getTitle())
            .description(occasion.getDescription())
            .createAt(occasion.getCreateAt())
            .products(occasion.getProducts())
            .build();
    }
}
