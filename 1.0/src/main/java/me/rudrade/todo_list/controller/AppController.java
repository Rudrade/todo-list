package me.rudrade.todo_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.rudrade.todo_list.model.Task;
import me.rudrade.todo_list.service.Taskservice;

@Controller
public class AppController {
    
    @Autowired
    private Taskservice taskservice;

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskservice.getAll());

        if (model.getAttribute("task") == null)
            model.addAttribute("task", new Task());
        
        return "app";
    }

    @PostMapping
    public String saveTask(@ModelAttribute Task task, RedirectAttributes redirectAttributes) {
        taskservice.save(task);
        
        redirectAttributes.addFlashAttribute("task", task);
        
        return "redirect:/";
    }
}
