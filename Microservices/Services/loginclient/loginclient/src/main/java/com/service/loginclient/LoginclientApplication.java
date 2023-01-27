package com.service.loginclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LoginclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginclientApplication.class, args);
	}

}
