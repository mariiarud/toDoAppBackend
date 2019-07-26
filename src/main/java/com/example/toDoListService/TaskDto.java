package com.example.toDoListService;

public class TaskDto {

    private int id;
    private int parentId;
    private String text;
    private boolean completed;

    public TaskDto(int id,int parentId,  String text, boolean completed) {
        this.id = id;
        this.text = text;
        this.parentId = parentId;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
