package com.thuytrang.littleflowershop.service;

import com.thuytrang.littleflowershop.model.Flower;

import java.util.List;

public interface FlowerService {
    List<Flower> retrievalFlowers();
    Flower detailFlower(Long id);
    Flower saveFlower(Flower flower);
    Flower updateFlower(Long id, Flower flower);
    void deleteFlower(Long id);
}