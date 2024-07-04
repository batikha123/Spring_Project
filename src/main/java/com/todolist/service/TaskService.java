package com.todolist.service;

import com.todolist.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    List<Task> getAllTodos();

    void saveTodo(Task todo);

    void deleteTodoById(UUID id);

    Task getTodoById(UUID id);

}
