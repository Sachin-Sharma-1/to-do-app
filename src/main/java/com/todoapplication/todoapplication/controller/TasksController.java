package com.todoapplication.todoapplication.controller;

import com.todoapplication.todoapplication.entity.Tasks;
import com.todoapplication.todoapplication.repo.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class TasksController {

    TasksRepository tasksRepository;

    @Autowired
    public TasksController(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }

    @GetMapping("/tasks/")
    public ResponseEntity<?> getTasks(){
        return ResponseEntity.ok(this.tasksRepository.findAll());
    }

    @PostMapping("/tasks/")
    @Transactional
    public ResponseEntity<?> addTask(@RequestBody Tasks theTask){
        theTask.setTicketId(theTask.getTicketId());
        Tasks save = this.tasksRepository.save(theTask);

        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable String id) {
        tasksRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/tasks/")
    public ResponseEntity<?> updateTask(@RequestBody Tasks[] updatedTasks){
        boolean resultFlag = false;
        List<Tasks> updatedResponses = new ArrayList<>();
        for (Tasks task:updatedTasks) {
            Tasks existingTask = tasksRepository.findById(task.getTicketId()).orElse(null);
            if(existingTask!=null) {
                existingTask.setTask(task.getTask());
                existingTask.setPriority(task.getPriority());
                Tasks theTask = tasksRepository.save(existingTask);
                if (theTask != null) {
                    updatedResponses.add(theTask);
                }
            }
        }
        if(!updatedResponses.isEmpty()){
            return  ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
