package com.mongodbexample.mongodbexample.entity;

import jdk.jfr.DataAmount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;

@Document(collection = "tasks")

public class Tasks {

    @Id
    private String ticketId;
    private String task;
    private String priority;

    public Tasks(String ticketId, String task, String priority) {
        this.ticketId = ticketId;
        this.task = task;
        this.priority = priority;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
