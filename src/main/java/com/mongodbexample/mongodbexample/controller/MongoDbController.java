package com.mongodbexample.mongodbexample.controller;

import com.mongodbexample.mongodbexample.entity.Student;
import com.mongodbexample.mongodbexample.entity.Tasks;
import com.mongodbexample.mongodbexample.repo.StudentRepository;
import com.mongodbexample.mongodbexample.repo.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class MongoDbController {

    StudentRepository studentRepository;

    TasksRepository tasksRepository;

    @Autowired
    public MongoDbController(StudentRepository studentRepository, TasksRepository tasksRepository){
        this.studentRepository = studentRepository;
        this.tasksRepository = tasksRepository;
    }

    @PostMapping("/student/")
    @Transactional
    public ResponseEntity<?> addStudent(@RequestBody Student theStudent){
        theStudent.setId(UUID.randomUUID().toString().split("-")[0]);
        Student save = this.studentRepository.save(theStudent);

        return ResponseEntity.ok(save);
    }

    @GetMapping("/student/")
    public ResponseEntity<?> getStudents(){
        return ResponseEntity.ok(this.studentRepository.findAll());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudents(@RequestParam String id){
        return ResponseEntity.ok(this.studentRepository.findByIdCustom(id));
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

    @DeleteMapping("/tasks/{id}")  // Map DELETE requests to /students/{id}
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        tasksRepository.deleteByIdCustom(id);
        return ResponseEntity.noContent().build();
    }

}
