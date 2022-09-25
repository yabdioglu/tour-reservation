package com.yabdioglu.tourreservation.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
public class TourRequest {

    private MultipartFile multipartFile;

    private String title;

    private String description;

    private BigDecimal priceForAdult;

    private BigDecimal priceForChild;

    private int quota;

}
