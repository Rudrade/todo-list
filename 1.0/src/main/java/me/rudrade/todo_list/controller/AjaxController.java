package me.rudrade.todo_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import me.rudrade.todo_list.service.TaskService;

@RestController
public class AjaxController {

    @Autowired
    private TaskService taskService;

    @PutMapping("/complete/{id}")
    public void changeCompletion(@PathVariable("id") String id) {
        taskService.changeTaskCompletion(id);
    }

}
