package com.thirdParty.oss.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Data
@ConfigurationProperties(prefix = "oss")
@Configuration
public class OssConfig {

  private String accessId;

  private String accessKey ;
  // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
  private String endpoint ;
  // 填写Bucket名称，例如examplebucket。
  private String bucket;

  @Bean
  public OSS ossClient(){
    log.info("accessId:{} accessKey:{} endpoint:{}",accessId,accessKey,endpoint);
    OSS oss = new OSSClientBuilder().build(endpoint, accessId, accessKey);
    return oss;
  }
}
