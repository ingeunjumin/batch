package com.data.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // batch를 위한 어노테이션
public class BatchApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

}
