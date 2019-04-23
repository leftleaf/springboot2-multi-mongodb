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
@EnableMongoRepositories(basePackages = "com.xth.webchat.dao", mongoTemplateRef = "messageMongo")
public class MessageMongoTemplate {

    @Autowired
    @Qualifier("messageMongoProperties")
    private MongoProperties mongoProperties;

    @Primary
    @Bean(name = "messageMongo")
    public MongoTemplate messageMongoTemplate() {
        return new MongoTemplate(messageFactory(this.mongoProperties));
    }

    @Bean
    @Primary
    public MongoDbFactory messageFactory(MongoProperties mongoProperties) {
        ServerAddress serverAddress = new ServerAddress(mongoProperties.getUri());
        return new SimpleMongoDbFactory(new MongoClient(serverAddress), mongoProperties.getDatabase());
    }
}
