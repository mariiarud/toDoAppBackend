package com.example.toDoListService.services;

import com.example.toDoListService.TaskDto;
import com.example.toDoListService.entities.Task;
import com.example.toDoListService.repositories.TaskListRepository;
import com.example.toDoListService.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    @Autowired
    private TaskListRepository taskListRepository;

    public TaskService(TaskRepository taskRepository,  TaskListRepository taskListRepository){
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    public List<TaskDto> getTasksByParentId(int parentId) {
        return taskRepository.findByParentIdOrderById(parentId)
                .stream()
                .map(this :: TaskToTaskDto)
                .collect(Collectors.toList());
    }

    public TaskDto saveTask(TaskDto task) {
        return TaskToTaskDto(taskRepository.save(DtoToTask(task)));
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    private Task DtoToTask(TaskDto taskDto){
        Task task = new Task(
                taskDto.getId(),
                taskListRepository.getOne(taskDto.getParentId()),
                taskDto.getText(),
                taskDto.isCompleted()
        );
        return task;
    }

    private TaskDto TaskToTaskDto(Task task){
        TaskDto taskDto = new TaskDto(
                task.getId(),
                task.getParent().getId(),
                task.getText(),
                task.isCompleted()
        );
        return taskDto;
    }
}
