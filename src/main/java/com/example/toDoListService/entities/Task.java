package com.example.toDoListService.entities;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private TaskList parent;

    @Column(name = "text")
    private String  text;

    @Column(name = "is_completed")
    private boolean completed;

    public Task() {
    }

    public Task(int id, TaskList parent, String text, boolean completed) {
        this.id = id;
        this.parent = parent;
        this.text = text;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskList getParent() {
        return parent;
    }

    public void setParent(TaskList parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}


