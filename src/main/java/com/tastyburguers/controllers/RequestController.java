package com.tastyburguers.controllers;

import com.tastyburguers.dtos.NewRequest;
import com.tastyburguers.models.Request;
import com.tastyburguers.services.RequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/request")
public class RequestController {
    
    @Autowired
    private RequestService ingredientService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Request> get(@PathVariable Integer id) throws Exception {
        Request ingredient = ingredientService.searchById(id);
        return ResponseEntity.ok(ingredient);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Request> register(@RequestBody NewRequest model) throws Exception {
        Request request = new Request(model.getClientName(),model.getMeal());
		return ResponseEntity.ok(ingredientService.insert(request));
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Request> update(@RequestBody NewRequest model, @PathVariable Integer id) throws Exception {
        Request request = new Request(model.getClientName(),model.getMeal());
        request.setId(id);
		return ResponseEntity.ok(ingredientService.update(request));
	}

    
}