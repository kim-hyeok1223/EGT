package com.egt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgtApplication.class, args);
	}

}
