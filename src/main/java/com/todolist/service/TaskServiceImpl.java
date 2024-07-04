package com.todolist.service;

import com.todolist.dao.TodoRepository;
import com.todolist.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TodoRepository todoRepository;

    @Override
    public List<Task> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public void saveTodo(Task todo) {
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodoById(UUID id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Task getTodoById(UUID id) {
        return todoRepository.findById(id).orElse(null);
    }

}
