package com.example.demoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class DemooApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemooApplication.class, args);
	}


}
