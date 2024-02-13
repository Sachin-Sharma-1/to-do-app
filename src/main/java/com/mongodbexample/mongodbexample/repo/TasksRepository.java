package com.mongodbexample.mongodbexample.repo;

import com.mongodbexample.mongodbexample.entity.Student;
import com.mongodbexample.mongodbexample.entity.Tasks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TasksRepository extends MongoRepository<Tasks, String> {

    @Query("{ '_id' : ?id }")
    Student deleteByIdCustom(String id);
}
