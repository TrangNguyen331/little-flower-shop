package com.thuytrang.littleflowershop.controller.api;

import com.thuytrang.littleflowershop.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilesController {
    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(
            @PathVariable String filename
    ) {
        Resource file = fileStorageService.load(filename);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
