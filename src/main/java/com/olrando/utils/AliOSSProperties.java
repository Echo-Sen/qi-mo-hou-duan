package com.olrando.utils;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;
// 这个文件用于 @@ConfigurationProperties注解的时候使用
@Data
@Component

@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
    //区域
    private String endpoint;
    //身份ID
    private String accessKeyId;
    //身份密钥
    private String accessKeySecret;
    //存储路径
    private String bucketName;

}
