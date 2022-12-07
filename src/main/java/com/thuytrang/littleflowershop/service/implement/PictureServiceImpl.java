package com.thuytrang.littleflowershop.service.implement;

import com.thuytrang.littleflowershop.exception.ResourceNotFoundException;
import com.thuytrang.littleflowershop.model.Picture;
import com.thuytrang.littleflowershop.model.Product;
import com.thuytrang.littleflowershop.payload.request.PictureRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.PictureResponse;
import com.thuytrang.littleflowershop.repository.PictureRepository;
import com.thuytrang.littleflowershop.repository.ProductRepository;
import com.thuytrang.littleflowershop.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureServiceImpl  implements PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<PictureResponse> retrievalPictures() {
        List<Picture> pictures = pictureRepository.findAll();

        List<PictureResponse> pictureResponses = new ArrayList<>();
        for (Picture picture: pictures) {
            pictureResponses.add(
                PictureResponse.builder()
                    .id(picture.getId())
                    .name(picture.getName())
                    .url(picture.getUrl())
                    .product(picture.getProduct())
                    .build()
            );
        }

        return pictureResponses;
    }

    @Override
    public PictureResponse detailPicture(Long id) {
        Picture picture = getPictureById(id);

        return PictureResponse.builder()
            .id(picture.getId())
            .name(picture.getName())
            .url(picture.getUrl())
            .product(picture.getProduct())
            .build();
    }

    @Override
    public PictureResponse createPicture(PictureRequest pictureRequest) {
        Product product = getProductById(pictureRequest.getProductId());
        Picture picture = Picture.builder()
            .name(pictureRequest.getName())
            .url(pictureRequest.getUrl())
            .product(product)
            .build();

        Picture newPicture = pictureRepository.save(picture);

        return PictureResponse.builder()
            .id(newPicture.getId())
            .name((newPicture.getName()))
            .url(newPicture.getUrl())
            .product(newPicture.getProduct())
            .build();
    }

    @Override
    public PictureResponse updatePicture(Long id, PictureRequest pictureRequest) {
        Product product = getProductById(pictureRequest.getProductId());
        Picture existsPicture = getPictureById(id);

        existsPicture.setName(pictureRequest.getName());
        existsPicture.setUrl(pictureRequest.getUrl());
        existsPicture.setProduct(product);
        Picture updatePicture = pictureRepository.save(existsPicture);

        return PictureResponse.builder()
            .id(updatePicture.getId())
            .name(updatePicture.getName())
            .url(updatePicture.getUrl())
            .product(updatePicture.getProduct())
            .build();
    }

    @Override
    public APIResponse deletePicture(Long id) {
        return null;
    }

    private Picture getPictureById(Long id) {
        return pictureRepository
            .findById(id)
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Picture")
                    .fieldValue("ID")
                    .build()
            );
    }

    private Product getProductById(Long id) {
        return productRepository
            .findById(id)
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Product")
                    .fieldValue("ID")
                    .build()
            );
    }
}
