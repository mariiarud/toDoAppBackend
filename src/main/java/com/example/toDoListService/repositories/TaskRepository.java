package com.example.toDoListService.repositories;

import com.example.toDoListService.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

//    @Query("SELECT task FROM Task ORDER BY task.id")
    List<Task> findByParentIdOrderById(int parentId);
}
