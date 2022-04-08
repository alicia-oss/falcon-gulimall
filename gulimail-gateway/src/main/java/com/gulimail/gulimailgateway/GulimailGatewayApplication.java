package com.gulimail.gulimailgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 导包
 * 1. 创建名称空间
 * 2.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class GulimailGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(GulimailGatewayApplication.class, args);
  }

}
