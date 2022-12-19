package com.thuytrang.littleflowershop.config;

import com.thuytrang.littleflowershop.LittleFlowerShopApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EntityScan(basePackageClasses = LittleFlowerShopApplication.class)
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("cors.allowedOrigins")
    private String allowedOrigins;

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        final long MAX_AGE_SECS = 3600;

        registry.addMapping("/**")
                .allowedOrigins(this.allowedOrigins)
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .maxAge(MAX_AGE_SECS);
    }
}
