package me.rudrade.todo_list.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.rudrade.todo_list.model.Task;

public interface TaskRespository extends MongoRepository<Task, String> {

}
