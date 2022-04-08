package com.thirdParty;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableConfigurationProperties
@SpringBootApplication
@EnableDiscoveryClient
public class ThirdPartyApplication {

  public static void main(String[] args) {
    SpringApplication.run(ThirdPartyApplication.class, args);
  }

}
