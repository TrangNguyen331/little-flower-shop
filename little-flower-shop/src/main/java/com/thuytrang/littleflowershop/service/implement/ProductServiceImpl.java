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
import com.thuytrang.littleflowershop.repository.PictureRepository;
import com.thuytrang.littleflowershop.repository.ProductRepository;
import com.thuytrang.littleflowershop.service.FileStorageService;
import com.thuytrang.littleflowershop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private PictureRepository pictureRepository;

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
            default -> products = productRepository.findAll();
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

        Product product = Product.builder()
                .title(productRequest.getTitle())
                .description(productRequest.getDescription())
                .storageLife(productRequest.getStorageLife())
                .dimensions(productRequest.getDimensions())
                .price(productRequest.getPrice())
                .design(design)
                .flowers(flowers)
                .occasions(occasions)
                .build();

        if (!Objects.equals(productRequest.getPicture().getOriginalFilename(), "")) {
            String fileName = "img_" + product.getTitle().toLowerCase() + "_" + Instant.now().getEpochSecond() + "_" + productRequest.getPicture().getOriginalFilename();
            String fileUrl = MessageFormat.format("/files/{0}", fileName);
            Picture picture = Picture.builder()
                    .name(fileName)
                    .url(fileUrl)
                    .product(product)
                    .build();
            product.setPicture(picture);

            fileStorageService.save(
                    productRequest.getPicture(),
                    fileName
            );
        } else {
            String fileName = "default_product.webp";
            String fileUrl = MessageFormat.format("/files/{0}", fileName);
            Picture picture = Picture.builder()
                    .name(fileName)
                    .url(fileUrl)
                    .product(product)
                    .build();

            product.setPicture(picture);
        }

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

        existsProduct.setTitle(productRequest.getTitle());
        existsProduct.setDescription(productRequest.getDescription());
        existsProduct.setStorageLife(productRequest.getStorageLife());
        existsProduct.setDimensions(productRequest.getDimensions());
        existsProduct.setPrice(productRequest.getPrice());
        existsProduct.setDesign(design);
        existsProduct.setFlowers(flowers);
        existsProduct.setOccasions(occasions);

        if (!Objects.equals(productRequest.getPicture().getOriginalFilename(), "")) {
            if (!Objects.equals(existsProduct.getPicture().getName(), "default_product.webp")) {
                fileStorageService.delete(existsProduct.getPicture().getName());
            }
            pictureRepository.delete(existsProduct.getPicture());


            String fileName = "img_" + existsProduct.getTitle().toLowerCase() + "_" + Instant.now().getEpochSecond() + "_" + productRequest.getPicture().getOriginalFilename();
            String fileUrl = MessageFormat.format("/files/{0}", fileName);
            Picture picture = Picture.builder()
                    .name(fileName)
                    .url(fileUrl)
                    .product(existsProduct)
                    .build();
            existsProduct.setPicture(picture);

            fileStorageService.save(
                    productRequest.getPicture(),
                    fileName
            );
        }

        Product updateProduct = productRepository.save(existsProduct);

        return responseBuilder(updateProduct);
    }

    @Override
    public APIResponse deleteProduct(Long id) {
        Product existsProduct = getProductById(id);

        if (!Objects.equals(existsProduct.getPicture().getName(), "default_product.webp")) {
            fileStorageService.delete(existsProduct.getPicture().getName());
        }

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
                .flowers(product.getFlowers())
                .occasions(product.getOccasions())
                .picture(product.getPicture())
                .createAt(product.getCreatedAtString())
                .lastModified(product.getCreatedAtString())
                .build();
    }
}
