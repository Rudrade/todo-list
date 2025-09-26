package me.rudrade.todo_list.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.rudrade.todo_list.model.Task;
import me.rudrade.todo_list.repository.TaskRespository;
import me.rudrade.todo_list.service.filter.TaskListFilter;

@Service
public class TaskService {

	@Autowired
    private TaskRespository respository;
    
    public List<Task> getAll(TaskListFilter filter, String text) {
        if (TaskListFilter.COMPLETED.equals(filter)) {
            return respository.findAllCompleted();
        
        } else if (TaskListFilter.SEARCH.equals(filter)) {
            return respository.findByName(text);
        }

        return respository.findAll();
    }

    public void delete(String id) {
        respository.deleteById(id);
    }

    public Task save(Task task) {
        return respository.save(task);
    }
    
    public Task getById(String id) {
        return respository.findById(id).get();
    }

    public void changeTaskCompletion(String id) {
        Optional<Task> optTask = respository.findById(id);
        if (optTask.isEmpty())
            return;

        Task task = optTask.get();
        task.setCompleted(!task.isCompleted());
        respository.save(task);
    }
}
