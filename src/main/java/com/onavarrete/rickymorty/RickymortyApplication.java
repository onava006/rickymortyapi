package com.onavarrete.rickymorty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RickymortyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RickymortyApplication.class, args);
	}

}