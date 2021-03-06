package com.gulimail.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.gulimail.ware.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class GulimailWareApplication {

  public static void main(String[] args) {
    SpringApplication.run(GulimailWareApplication.class, args);
  }

}
