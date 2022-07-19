package com.sumtech.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumtech.app.exception.ResourceNotFoundException;
import com.sumtech.app.model.Operation;
import com.sumtech.app.repository.OperationRepository;



@RestController
@RequestMapping("/api/v1/")
public class OperationController {

      @Autowired
      private OperationRepository operationRepository;
      
      //get all operations
      @GetMapping("/operations")
      public List<Operation> getAllOperations(){
            return operationRepository.findAll();
      }

      // create operation rest api
	@PostMapping("/operations")
	public Operation createOperation(@RequestBody Operation operation) {
		return operationRepository.save(operation);
	}

      // get operation by id rest api
	@GetMapping("/operations/{id}")
	public ResponseEntity<Operation> getOperationById(@PathVariable Long id) {
		Operation operation = operationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Operation not exist with id :" + id));
		return ResponseEntity.ok(operation);
	}

      // update operation rest api
	@PutMapping("/operations/{id}")
	public ResponseEntity<Operation> updateOperation(@PathVariable Long id, @RequestBody Operation operationDetails){
		Operation operation = operationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Operation not exist with id :" + id));
		
		operation.setFirstNameCustomer(operationDetails.getFirstNameCustomer());
		operation.setLastNameCustomer(operationDetails.getLastNameCustomer());
		operation.setProducts(operationDetails.getProducts());
            operation.setQuantity(operationDetails.getQuantity());
		operation.setTotal(operationDetails.getTotal());
		operation.setDate(operationDetails.getDate());
		
		Operation updatedOperation = operationRepository.save(operation);
		return ResponseEntity.ok(updatedOperation);
	}

      // delete operation rest api
	@DeleteMapping("/operations/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOperation(@PathVariable Long id){
		Operation operation = operationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Operation not exist with id :" + id));
		
		operationRepository.delete(operation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}