package com.thuytrang.littleflowershop.service.implement;

import com.thuytrang.littleflowershop.exception.ResourceNotFoundException;
import com.thuytrang.littleflowershop.model.Design;
import com.thuytrang.littleflowershop.model.Flower;
import com.thuytrang.littleflowershop.model.Occasion;
import com.thuytrang.littleflowershop.model.Picture;
import com.thuytrang.littleflowershop.model.Product;
import com.thuytrang.littleflowershop.payload.request.ProductRequest;
import com.thuytrang.littleflowershop.payload.response.APIResponse;
import com.thuytrang.littleflowershop.payload.response.ProductResponse;
import com.thuytrang.littleflowershop.repository.DesignRepository;
import com.thuytrang.littleflowershop.repository.FlowerRepository;
import com.thuytrang.littleflowershop.repository.OccasionRepository;
import com.thuytrang.littleflowershop.repository.ProductRepository;
import com.thuytrang.littleflowershop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DesignRepository designRepository;

    @Autowired
    private FlowerRepository flowerRepository;

    @Autowired
    private OccasionRepository occasionRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public List<ProductResponse> retrievalProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product: products) {
            productResponses.add(
                this.responseBuilder(product)
            );
        }

        return productResponses;
    }

    @Override
    public List<ProductResponse> filterProducts(String by, String keyword) {
        List<Product> products;

        switch (by) {
            case "id" -> {
                try {
                    products = productRepository.findById((long) Integer.parseInt(keyword)).stream().toList();
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            case "title" -> products = productRepository.filterByTitle(keyword);
            case "design" -> products = productRepository.filterByDesign(keyword);
            default -> products = new ArrayList<>();
        }

        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product: products) {
            productResponses.add(
                this.responseBuilder(product)
            );
        }

        return productResponses;
    }

    @Override
    public ProductResponse detailProduct(Long id) {
        Product product = this.getProductById(id);

        return this.responseBuilder(product);
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Design design = designRepository
            .findById(productRequest.getDesignId())
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Design")
                    .fieldName("ID")
                    .fieldValue(productRequest.getDesignId())
                    .build()
            );

        List<Flower> flowers = flowerRepository
            .findAllById(productRequest.getFlowers());

        List<Occasion> occasions = occasionRepository
            .findAllById(productRequest.getOccasions());

        List<Picture> pictures = new ArrayList<>();
        for (MultipartFile file: productRequest.getImages()) {
            String fileName = file.getOriginalFilename();
            String fileUrl = MessageFormat.format("/{0}", fileName);
            try {
                FileCopyUtils.copy(file.getBytes(), new File(this.uploadPath + fileName));
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            pictures.add(
                Picture.builder()
                    .name(fileName)
                    .url(fileUrl)
                    .build()
            );
        }

        Product product = Product.builder()
            .title(productRequest.getTitle())
            .description(productRequest.getDescription())
            .storageLife(productRequest.getStorageLife())
            .dimensions(productRequest.getDimensions())
            .price(productRequest.getPrice())
            .design(design)
            .flowers(flowers)
            .occasions(occasions)
            .pictures(pictures)
            .build();

        Product newProduct = productRepository.save(product);

        return this.responseBuilder(newProduct);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product existsProduct = getProductById(id);

        Design design = designRepository
            .findById(productRequest.getDesignId())
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Design")
                    .fieldName("ID")
                    .fieldValue(productRequest.getDesignId())
                    .build()
            );

        List<Flower> flowers = flowerRepository
            .findAllById(productRequest.getFlowers());

        List<Occasion> occasions = occasionRepository
            .findAllById(productRequest.getOccasions());

        List<Picture> pictures = new ArrayList<>();
        for (MultipartFile file: productRequest.getImages()) {
            String fileName = file.getOriginalFilename();
            String fileUrl = MessageFormat.format("/{0}", fileName);
            try {
                FileCopyUtils.copy(file.getBytes(), new File(this.uploadPath + fileName));
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            pictures.add(
                Picture.builder()
                    .name(fileName)
                    .url(fileUrl)
                    .build()
            );
        }

        existsProduct.setTitle(productRequest.getTitle());
        existsProduct.setDescription(productRequest.getDescription());
        existsProduct.setStorageLife(productRequest.getStorageLife());
        existsProduct.setDimensions(productRequest.getDimensions());
        existsProduct.setPrice(productRequest.getPrice());
        existsProduct.setDesign(design);
        existsProduct.setFlowers(flowers);
        existsProduct.setOccasions(occasions);
        existsProduct.setPictures(pictures);

        Product updateProduct = productRepository.save(existsProduct);

        return responseBuilder(updateProduct);
    }

    @Override
    public APIResponse deleteProduct(Long id) {
        Product existsProduct = getProductById(id);

        productRepository.delete(existsProduct);

        return APIResponse.builder()
            .success(Boolean.TRUE)
            .message("Product deleted success")
            .build();
    }

    private Product getProductById(Long id) {
        return productRepository
            .findById(id)
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Product")
                    .fieldName("ID")
                    .fieldValue(id)
                    .build()
            );
    }

    private ProductResponse responseBuilder(Product product) {
        return ProductResponse.builder()
            .id(product.getId())
            .title(product.getTitle())
            .description(product.getDescription())
            .storageLife(product.getStorageLife())
            .dimensions(product.getDimensions())
            .price(product.getPrice())
            .design(product.getDesign())
            .createAt(product.getCreateAt())
            .flowers(product.getFlowers())
            .occasions(product.getOccasions())
            .pictures(product.getPictures())
            .build();
    }
}
