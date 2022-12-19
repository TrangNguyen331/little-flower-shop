package com.thuytrang.littleflowershop.service.implement;

import com.thuytrang.littleflowershop.exception.ResourceNotFoundException;
import com.thuytrang.littleflowershop.model.Flower;
import com.thuytrang.littleflowershop.payload.request.FlowerRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.FlowerResponse;
import com.thuytrang.littleflowershop.repository.FlowerRepository;
import com.thuytrang.littleflowershop.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;

    @Override
    public List<FlowerResponse> retrievalFlowers() {
        List<Flower> flowers = flowerRepository.findAll();

        List<FlowerResponse> flowerResponses = new ArrayList<>();
        for (Flower flower: flowers) {
            flowerResponses.add(
                    this.responseBuilder(flower)
            );
        }

        return flowerResponses;
    }

    @Override
    public List<FlowerResponse> filterFlowers(String by, String keyword) {
        List<Flower> flowers;

        switch (by) {
            case "id" -> {
                try {
                    flowers = flowerRepository.findById((long) Integer.parseInt(keyword)).stream().toList();
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            case "kind" -> flowers = flowerRepository.filterByKind(keyword);
            case "color" -> flowers = flowerRepository.filterByColor(keyword);
            default -> flowers = flowerRepository.findAll();
        }

        List<FlowerResponse> flowerResponses = new ArrayList<>();
        for (Flower flower: flowers) {
            flowerResponses.add(
                    this.responseBuilder(flower)
            );
        }

        return flowerResponses;
    }

    @Override
    public FlowerResponse detailFlower(Long id) {
        Flower flower = getFlowerById(id);

        return this.responseBuilder(flower);
    }

    @Override
    public FlowerResponse createFlower(FlowerRequest flowerRequest) {
        Flower flower = Flower.builder()
                .kind(flowerRequest.getKind())
                .color(flowerRequest.getColor())
                .description(flowerRequest.getDescription())
                .build();

        Flower newFlower = flowerRepository.save(flower);

        return this.responseBuilder(newFlower);
    }

    @Override
    public FlowerResponse updateFlower(Long id, FlowerRequest flowerRequest) {
        Flower existsFlower = getFlowerById(id);

        existsFlower.setKind(flowerRequest.getKind());
        existsFlower.setColor(flowerRequest.getColor());
        existsFlower.setDescription(flowerRequest.getDescription());

        Flower updateFlower = flowerRepository.save(existsFlower);

        return responseBuilder(updateFlower);
    }

    @Override
    public APIResponse deleteFlower(Long id) {
        Flower existsFlower = getFlowerById(id);

        flowerRepository.delete(existsFlower);

        return APIResponse.builder()
                .success(Boolean.TRUE)
                .message("Flower deleted success")
                .build();
    }

    private Flower getFlowerById(Long id) {
        return flowerRepository
                .findById(id)
                .orElseThrow(() ->
                        ResourceNotFoundException.builder()
                                .resourceName("Flower")
                                .fieldName("ID")
                                .fieldValue(id)
                                .build()
                );
    }

    private FlowerResponse responseBuilder(Flower flower) {
        return FlowerResponse.builder()
                .id(flower.getId())
                .kind(flower.getKind())
                .color(flower.getColor())
                .description(flower.getDescription())
                .createAt(flower.getCreatedAtString())
                .lastModified(flower.getUpdatedAtString())
                .build();
    }
}
