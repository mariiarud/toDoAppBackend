package com.example.toDoListService.services;

import com.example.toDoListService.entities.TaskList;
import com.example.toDoListService.repositories.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository taskListRepository;

    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public List<TaskList> getTaskLists() {
        return taskListRepository.findAll();
    }

    public TaskList addTaskList(TaskList list) {
        return taskListRepository.save(list);
    }

    public void deleteTaskList(int id) {
        taskListRepository.deleteById(id);
    }
}
