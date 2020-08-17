package com.tastyburguers.services;

import java.util.Optional;

import com.tastyburguers.models.Request;
import com.tastyburguers.repositories.RequestRepository;
import com.tastyburguers.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    public Request searchById(Integer id) {
        Optional <Request> ingredient = repository.findById(id);
        return ingredient.orElseThrow(() -> new ObjectNotFoundException ("Object not found: " + id));
    }

    public Request insert(Request obj) {
        return repository.save(obj);
    }

    public Request update(Request obj) {
        searchById(obj.getId());
        return repository.save(obj);
    }
    
}