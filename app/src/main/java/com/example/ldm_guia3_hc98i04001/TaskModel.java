package com.example.ldm_guia3_hc98i04001;


import java.io.Serializable;

public class TaskModel implements Serializable{
    private String task_name;

    public TaskModel() {
    }

    public TaskModel(String taskName) {
        this.task_name = taskName;
    }

    public String getTaskName() {
        return task_name;
    }

}
