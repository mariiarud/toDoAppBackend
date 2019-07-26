package com.example.toDoListService.controller;

import com.example.toDoListService.entities.TaskList;
import com.example.toDoListService.repositories.TaskListRepository;
import com.example.toDoListService.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lists")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    public TaskListController(TaskListRepository taskListRepository){
        this.taskListService = taskListService;
    }

    @GetMapping
    public List<TaskList> getAllTaskLists(){
        return taskListService.getTaskLists();
    }

    @PostMapping()
    public TaskList create(@RequestBody TaskList list) {
//        taskListRepository.save(list);
        return taskListService.addTaskList(list);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        taskListService.deleteTaskList(id);
    }
}

