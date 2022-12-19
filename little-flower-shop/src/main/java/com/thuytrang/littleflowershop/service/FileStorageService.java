package com.thuytrang.littleflowershop.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;


public interface FileStorageService {
    public void init();
    public void save(MultipartFile file, String fileName);
    public Resource load(String filename);
    public void delete(String filename);
    public void deleteAll();
}
