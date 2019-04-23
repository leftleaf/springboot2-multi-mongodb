package com.xth.webchat.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MultipleMongoProperties {

    @Bean(name = "userMongoProperties")
    @Primary
    @ConfigurationProperties(prefix = "spring.data.mongodb.user")
    public MongoProperties userMongoProperties() {
        System.out.println("-----------StartUserMongoPropertiesInit----------");
        return new MongoProperties();
    }

    @Bean(name = "messageMongoProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.message")
    public MongoProperties messageMongoProperties() {
        System.out.println("-----------StartMessageMongoPropertiesInit----------");
        return new MongoProperties();
    }
}
