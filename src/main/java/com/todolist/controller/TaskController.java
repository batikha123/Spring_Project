package com.todolist.controller;

import com.todolist.domain.Task;
import com.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("tasks", taskService.getAllTodos());
        return "index";
    }

    @GetMapping("/add")
    public String showAddTodoForm(Model model) {
        Task task = new Task();
        List<String> categories = Arrays.asList("Work", "Personal", "Shopping", "Fitness", "Health", "Finance", "Education", "Travel", "Others");
        model.addAttribute("task", task);
        model.addAttribute("categories", categories);
        return "add_todo";
    }

    @PostMapping("/save")
    public String saveTodo(@ModelAttribute("task") Task task) {
        taskService.saveTodo(task);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable(value = "id") UUID id) {
        taskService.deleteTodoById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditTodoForm(@PathVariable(value = "id") UUID id, Model model) {
        Task task = taskService.getTodoById(id);
        List<String> categories = Arrays.asList("Work", "Personal", "Shopping", "Fitness", "Health", "Finance", "Education", "Travel", "Others");
        model.addAttribute("task", task);
        model.addAttribute("categories", categories);
        return "edit_todo";
    }
}
