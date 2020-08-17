package com.tastyburguers.repositories;

import com.tastyburguers.models.Request;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository <Request, Integer>{
    
}