package com.telegramifix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TelegramIfixApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramIfixApplication.class, args);
	}

}
