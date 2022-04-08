package com.gulimail.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.gulimail.coupon.dao")
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class GulimailCouponApplication {

  public static void main(String[] args) {
    SpringApplication.run(GulimailCouponApplication.class, args);
  }

}
