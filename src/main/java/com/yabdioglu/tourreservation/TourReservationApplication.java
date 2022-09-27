package com.yabdioglu.tourreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class TourReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourReservationApplication.class, args);
	}

}