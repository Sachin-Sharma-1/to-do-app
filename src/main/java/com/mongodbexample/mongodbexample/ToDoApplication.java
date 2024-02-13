package com.mongodbexample.mongodbexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ToDoApplication{

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}

}
