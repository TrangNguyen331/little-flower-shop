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
                FlowerResponse.builder()
                    .id(flower.getId())
                    .kind(flower.getKind())
                    .color(flower.getColor())
                    .products(flower.getProducts())
                    .build()
            );
        }

        return flowerResponses;
    }

    @Override
    public FlowerResponse detailFlower(Long id) {
        Flower flower = getFlowerById(id);

        return FlowerResponse.builder()
            .id(flower.getId())
            .kind(flower .getKind())
            .color(flower.getColor())
            .products(flower.getProducts())
            .build();
    }

    @Override
    public FlowerResponse createFlower(FlowerRequest flowerRequest) {
        Flower flower = Flower.builder()
            .kind(flowerRequest.getKind())
            .color(flowerRequest.getColor())
            .build();

        Flower newFlower = flowerRepository.save(flower);

        return FlowerResponse.builder()
            .id(newFlower.getId())
            .kind(newFlower.getKind())
            .color(newFlower.getColor())
            .build();
    }

    @Override
    public FlowerResponse updateFlower(Long id, FlowerRequest flowerRequest) {
        Flower existsFlower = getFlowerById(id);

        existsFlower.setKind(flowerRequest.getKind());
        existsFlower.setColor(flowerRequest.getColor());
        Flower updateFlower = flowerRepository.save(existsFlower);

        return FlowerResponse.builder()
            .id(updateFlower.getId())
            .kind(updateFlower.getKind())
            .color(updateFlower.getColor())
            .build();
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
}
