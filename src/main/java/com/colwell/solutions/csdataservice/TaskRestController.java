package com.colwell.solutions.csdataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TaskRestController {

    @Autowired
    private CrudRepository<Task, String> taskRepository;

    @RequestMapping(value = "/repository-task")
    public Task createTask(){
        Random rand = new Random();
        String temp = String.valueOf(rand.nextLong());
        return taskRepository.save(new Task("New Task" + temp));
    }

}
