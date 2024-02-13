package com.todoapplication.todoapplication.repo;

import com.todoapplication.todoapplication.entity.Tasks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TasksRepository extends MongoRepository<Tasks, String> {

    @Query("{ '_id' : ?id }")
    Tasks deleteByIdCustom(String id);
}
