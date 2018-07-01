package com.colwell.solutions.csdataservice;


import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String> {

}
