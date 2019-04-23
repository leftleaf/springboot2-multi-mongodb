package com.xth.webchat.config;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.xth.webchat.dao", mongoTemplateRef = "userMongo")
public class UserMongoTemplate {

    @Autowired
    @Qualifier("userMongoProperties")
    private MongoProperties mongoProperties;

    @Primary
    @Bean(name = "userMongo")
    public MongoTemplate userMongoTemplate() {
        return new MongoTemplate(userFactory(this.mongoProperties));
    }

    @Bean
    @Primary
    public MongoDbFactory userFactory(MongoProperties mongoProperties) {
        ServerAddress serverAddress = new ServerAddress(mongoProperties.getUri());
        return new SimpleMongoDbFactory(new MongoClient(serverAddress), mongoProperties.getDatabase());
    }
}
