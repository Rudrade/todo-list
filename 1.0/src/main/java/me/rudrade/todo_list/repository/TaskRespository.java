package me.rudrade.todo_list.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.client.MongoClient;

import me.rudrade.todo_list.model.Task;

public class TaskRespository {
    
    @Autowired private MongoClient mongoClient;

    public List<Task> getTasks() {
        
    }

}
