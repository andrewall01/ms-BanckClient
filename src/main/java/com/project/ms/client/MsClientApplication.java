package com.project.ms.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

/**
 * Public class MsClientApplication for microservices ms_BankClient.
 * 
 * @author Andres Llontop
 *
 */

@SpringBootApplication
@EnableReactiveMongoAuditing
@EnableEurekaClient
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
public class MsClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsClientApplication.class, args);
  }

}
