package com.thuytrang.littleflowershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = LittleFlowerShopApplication.class)
public class LittleFlowerShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(LittleFlowerShopApplication.class, args);
    }

}