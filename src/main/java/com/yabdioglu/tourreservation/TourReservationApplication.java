package com.yabdioglu.tourreservation;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableSwagger2
@PropertySource("classpath:config.properties")
public class TourReservationApplication {

    @Autowired
    Environment env;

    public static void main(String[] args) {
        SpringApplication.run(TourReservationApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yabdioglu.tourreservation"))
                .build();
    }

    @Bean
    public Cloudinary cloudinaryConfig() {
        Cloudinary cloudinary = null;
        Map config = new HashMap();
        config.put("cloud_name", env.getProperty("cloud.name"));
        config.put("api_key", env.getProperty("api.key"));
        config.put("api_secret", env.getProperty("api.secret"));
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }

}
