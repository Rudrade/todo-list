package me.rudrade.todo_list.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.rudrade.todo_list.model.Task;
import me.rudrade.todo_list.repository.TaskRespository;

@Service
public class Taskservice {

    @Autowired
    private TaskRespository respository;
    

    public List<Task> getAll() {
        return respository.findAll();
    }

    public void delete(String id) {
        respository.deleteById(id);
    }

    public Task save(Task task) {
        return respository.save(task);
    }
}
