package com.example.springbootdatamongodb.repository;

import com.example.springbootdatamongodb.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository  extends MongoRepository<Department, String> {

}
