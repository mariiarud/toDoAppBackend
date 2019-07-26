package com.example.toDoListService.controller;

import com.example.toDoListService.TaskDto;
import com.example.toDoListService.entities.Task;
import com.example.toDoListService.repositories.TaskRepository;
import com.example.toDoListService.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDto> getTasksByParentId(@RequestParam int parentId){
        return taskService.getTasksByParentId(parentId);
    }

    @PostMapping()
    public TaskDto create(@RequestBody TaskDto task) {
        return taskService.saveTask(task);
    }

    @PatchMapping("{id}")
    public TaskDto update(@PathVariable int id, @RequestBody  TaskDto task) {
        return taskService.saveTask(task);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
