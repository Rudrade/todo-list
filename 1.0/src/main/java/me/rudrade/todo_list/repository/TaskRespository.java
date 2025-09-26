package me.rudrade.todo_list.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import me.rudrade.todo_list.model.Task;

public interface TaskRespository extends MongoRepository<Task, String> {

    @Query("{ 'completed' : true }")
    List<Task> findAllCompleted();

    @Query("{ 'name' : ?0 }")
    List<Task> findByName(String name);

}
