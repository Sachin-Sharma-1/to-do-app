package com.mongodbexample.mongodbexample.repo;

import com.mongodbexample.mongodbexample.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends MongoRepository<Student, Integer> {

    @Query("{ '_id' : ?id }")
    Student findByIdCustom(String id);




}
