package com.thuytrang.littleflowershop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(
    info = @Info(
        title = "Little Flower Shop - API",
        version = "1.0",
        contact = @Contact(
            url = "https://github.com/TrangNguyen331/little-flower-shop",
            name = "Thùy Trang"
        )
    )
)
@SpringBootApplication
public class LittleFlowerShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(LittleFlowerShopApplication.class, args);
    }

}