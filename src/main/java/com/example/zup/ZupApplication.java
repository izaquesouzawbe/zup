package com.example.zup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZupApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZupApplication.class, args);
	}

}
