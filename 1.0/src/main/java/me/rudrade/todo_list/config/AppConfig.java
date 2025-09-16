package me.rudrade.todo_list.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class AppConfig {
    
    public @Bean MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017"); // TODO: Config get from file
    }

}
