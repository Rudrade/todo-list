package me.rudrade.todo_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.rudrade.todo_list.model.Task;
import me.rudrade.todo_list.service.TaskService;
import me.rudrade.todo_list.service.filter.TaskListFilter;

@Controller
@RequestMapping
public class AppController {
    
	@Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String listTasks(Model model,
        @RequestParam(required = false) TaskListFilter filter,
        @RequestParam(name = "search", required = false) String searchText) {
        
        model.addAttribute("tasks", taskService.getAll(filter, searchText));

        if (model.getAttribute("task") == null)
            model.addAttribute("task", new Task());

        return "app";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task, RedirectAttributes redirectAttributes) {
        taskService.save(task);
        
        redirectAttributes.addFlashAttribute("task", task);
        
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable String id) {
        taskService.delete(id);

        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public Task getTask(@PathVariable String id) {
        return taskService.getById(id);
    }

}
