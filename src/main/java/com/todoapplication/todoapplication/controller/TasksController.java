package com.todoapplication.todoapplication.controller;

import com.todoapplication.todoapplication.entity.Tasks;
import com.todoapplication.todoapplication.repo.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        tasksRepository.deleteByIdCustom(id);
        return ResponseEntity.noContent().build();
    }

}
