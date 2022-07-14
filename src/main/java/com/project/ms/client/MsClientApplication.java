package com.project.ms.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@SpringBootApplication
@EnableReactiveMongoAuditing
public class MsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsClientApplication.class, args);
	}

}
