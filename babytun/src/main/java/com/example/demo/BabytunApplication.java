package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.demo")  // mybatis
@EnableCaching
@EnableScheduling
public class BabytunApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabytunApplication.class, args);
	}

}
