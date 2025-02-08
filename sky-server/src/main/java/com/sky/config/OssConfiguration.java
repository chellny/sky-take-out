package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
*   创建AliOssUtil对象
* */
@Configuration
@Slf4j
public class OssConfiguration {
    /*
    *   保证只有一个bean
    * */

    @Bean
    @ConditionalOnMissingBean
    public AliOssUtil ossConfig(AliOssProperties properties) {
        AliOssUtil aliOssUtil = new AliOssUtil(properties.getEndpoint(),properties.getAccessKeyId(),
                properties.getAccessKeySecret(), properties.getBucketName());
        return aliOssUtil;
    }
}
