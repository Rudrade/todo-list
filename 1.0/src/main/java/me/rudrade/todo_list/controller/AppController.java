package me.rudrade.todo_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import me.rudrade.todo_list.service.Taskservice;

@Controller
public class AppController {
    
    @Autowired
    private Taskservice taskservice;

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskservice.getAll());

        return  "app";
    }

}
